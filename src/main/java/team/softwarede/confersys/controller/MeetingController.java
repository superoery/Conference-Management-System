package team.softwarede.confersys.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.biz.LeaveApplicationBiz;
import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.biz.ShowMainPageOrgBiz;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumRoleName;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	InformBiz informBiz;
	@Autowired
	LeaveExaminationBiz leaveExaminationBiz;
	@Autowired
	ShowMeetingDetail2Biz showMeetingDetail2Biz;
	@Autowired
	LeaveApplicationBiz leaveApplicationBiz;
	@Autowired
	ShowMeetingMainPageBiz showMeetingMainPageBiz;
    @Autowired
    ShowMainPageOrgBiz showMainPageOrgBiz;
	@Autowired
	MeetingBiz meetingBiz; 
	
	@RequestMapping("/show_list.do")
	public String showMeetingList(ModelMap map,
			@ModelAttribute("userlogin") UserLogin userlogin,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		List<MeetingMainPage> pmtList = showMeetingMainPageBiz.showMeetingMainPage(userSession.getUserId(), userSession.getRole().getId());
		map.addAttribute("pmtList",pmtList);
		
		List<MeetingMainPage> omtList = showMainPageOrgBiz.showMainPageOrg(userSession.getUserId(), userSession.getRole().getId());
		map.addAttribute("omtList",omtList);
		
		List<MeetingMainPage> amtList = showMeetingMainPageBiz.showMeetingMainPage(userSession.getUserId(), userSession.getRole().getId());
		map.addAttribute("amtList",amtList);
		
		return "login_main";
	}
	
	/**
	 * 审核会议室申请
	 */
	@RequestMapping(value = "/audit.do" , params = {"mtRoomApplyId","mtRoomApplyStatus"})
	public String auditMeeingBookApply(ModelMap map,
									   @ModelAttribute("mtRoomApplyId")Integer mtRoomApplyId,
									   @ModelAttribute("mtRoomApplyStatus")Integer mtRoomApplyStatus) {
		
		String msg = null;
		String url = null;
		String title = "审核会议室申请";
		
		boolean result = informBiz.auditMeeingBookApply(mtRoomApplyId, mtRoomApplyStatus);
		if(result==true) {
			msg = "会议室申请已审核";
			url = "result_show";
		}else {
			msg = "会议室申请审核失败，请重新审核！";
			url = "redirect:/inform/sp/list.do";
		}
		map.addAttribute("msg", msg);
		map.addAttribute("title", title);
		return url;
	}
	
	

	@RequestMapping(value = "/leave/audit.do",params = {"audit","meetingId","userId"})
	public String auditLeave(ModelMap map,
							 @ModelAttribute("audit")Integer audit,
							 @ModelAttribute("meetingId")Integer meetingId,
							 @ModelAttribute("userId")String userId) {
		String result;
		String title = "审核请假申请";
		String msg = null;
		LeaveApplication leaveApplication = new LeaveApplication();
		
		leaveApplication.setMeetingId(meetingId);
		leaveApplication.setUserId(userId);

		result = leaveExaminationBiz.leaveExamination(leaveApplication, audit);
		if(result.equals("SUCCEED!")) {
			msg = "审核请假申请成功";
		}else {
			msg = "审核请假失败，请重新操作";
		}
		
		map.addAttribute("title", title);
		map.addAttribute("msg", msg);
		return "forward:/universal/result/show.do";
	}
	


	@RequestMapping(value = "/mt_detail.do", params = {"mtId"})
	public String index(ModelMap map, 
			@ModelAttribute("mtId") int mtId,
			HttpSession session) {

		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		Role role = userSession.getRole();
		MeetingDetail mtDetail = showMeetingDetail2Biz.showMeetingDetail2(userSession.getUserId(), mtId, role.getId());
		List<ParticipantBasicInfo> participantsList = showMeetingDetail2Biz.showMeetingDetail(mtId, role.getId());
		map.addAttribute("mtDetail", mtDetail);
		map.addAttribute("participantsList", participantsList);

		return "meeting_detail";
    }
	
	/**
	 * 显示请假详情
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/leave/apply/show.do")
	public String showLeaveApplyPage(ModelMap map,
									 HttpSession session) {
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		List<MeetingMainPage> meetingList = 
				showMeetingMainPageBiz.showMeetingMainPage(userSession.getUserId(),
														   userSession.getRole().getId());

		map.addAttribute("meetingList", meetingList);
		
		return "meeting_leave_apply";
	}
	
	/**
	 * 提交请假申请
	 */
	@RequestMapping(value = "/leave/apply/apply.do",method = RequestMethod.POST)
	public String applyLeaveApply(ModelMap map,
								  HttpSession session,								  
								  @ModelAttribute("reason")String reason,
								  @ModelAttribute("meetingId")Integer meetingId) {

		LeaveApplication leaveApplication = new LeaveApplication();
		String result = null;
		String title = "申请请假";
		String msg = null;
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		String userId = userSession.getUserId();

		leaveApplication.setUserId(userId);
		leaveApplication.setReason(reason);
		leaveApplication.setMeetingId(meetingId);
		
		result = leaveApplicationBiz.submitLeaveApplication(leaveApplication);
		
		if(result.equals("succeed")) {
			
			msg = "申请请假成功";
			
		}else {
			msg = "申请请假失败";
		}
		
		return "forward:/universal/result/show.do";
		
	}
	
	/**
	 * 显示会议信息修改界面
	 */
	@RequestMapping(value = "/details/edit.do",params = {"meetingId"},method = RequestMethod.GET)
	public String showEditMtDetailsPage(ModelMap map,
										HttpSession session,
										@ModelAttribute("meetingId")Integer meetingId,
										@ModelAttribute("mtContent")String mtContent,
										@ModelAttribute("mtConclude")String mtConclude) {
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		MeetingDetail meetingDetail = showMeetingDetail2Biz.showMeetingDetail2(userSession.getUserId(), 
																			   meetingId, 
																			   userSession.getRole().getId());
		
//		System.out.println("会议编号1："+meetingDetail.getMtId());
//		
//		System.out.println("会议编号2："+meetingId);
		
		
		map.addAttribute("details", meetingDetail);
		map.addAttribute("meetingId", meetingId);
		
		return "meeting_details_edit";
	}
	
	
	/**
	 * 会议信息修改
	 */
	@RequestMapping(value = "/details/edit.do",method = RequestMethod.POST)
	public String editMeetingContent(ModelMap map,
									 @ModelAttribute("meetingId")Integer meetingId,
									 @ModelAttribute("mtContent")String mtContent,
									 @ModelAttribute("mtConclude")String mtConclude
									 ) {
		String title = "修改会议信息";
		String msg = null;
		
		boolean result = meetingBiz.editMeetingContent(meetingId, mtContent, mtConclude);
//		System.out.println("会议编号："+ meetingId);
//		System.out.println("会议内容："+ mtContent);
//		System.out.println("会议结论："+ mtConclude);
		
		if(result==true) {
			msg = "修改成功";
		}else {
			msg = "修改失败";
		}
		
		map.addAttribute("title", title);
		map.addAttribute("msg", msg);
			
		return "forward:/universal/result/show.do";
	}
	
	
}
