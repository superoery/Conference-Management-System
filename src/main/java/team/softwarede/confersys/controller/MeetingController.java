package team.softwarede.confersys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
import team.softwarede.confersys.entity.Role;

@Controller
@RequestMapping("/meeting")
public class MeetingController {
	@Autowired
	ShowMeetingDetail2Biz showMeetingDetail2Biz;

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
