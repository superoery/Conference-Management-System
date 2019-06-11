package team.softwarede.confersys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.InformBiz;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	InformBiz informBiz;
	
	
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

	
	
}
