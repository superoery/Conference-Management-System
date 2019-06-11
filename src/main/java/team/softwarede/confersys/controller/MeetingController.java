package team.softwarede.confersys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.entity.LeaveApplication;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	InformBiz informBiz;
	@Autowired
	LeaveExaminationBiz leaveExaminationBiz;
	
	
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
	
	
}
