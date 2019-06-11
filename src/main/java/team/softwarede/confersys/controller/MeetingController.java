package team.softwarede.confersys.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
import team.softwarede.confersys.entity.Role;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	InformBiz informBiz;
	@Autowired
	LeaveExaminationBiz leaveExaminationBiz;
	@Autowired
	ShowMeetingDetail2Biz showMeetingDetail2Biz;
	
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

		return "mt_detail";
    }
	
}