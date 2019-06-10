package team.softwarede.confersys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.biz.NotificationBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.dto.NotificationMainPage;

@Controller
@RequestMapping("/inform")
public class InformController {

	@Autowired
	InformBiz informBiz;
//	@Autowired
//	NotificationBiz notificationBiz;

	@RequestMapping(value = "/normal/details.do",params = {"informId"},method = RequestMethod.GET)
	public String showNormalInformDetails(ModelMap map,
										  @ModelAttribute("informId")Integer informId) {
		
		NotificationDetail notiDetails = informBiz.showNormalInformDetail(informId);
		map.addAttribute("notiDetails", notiDetails);
		
		return "inform_details_show";
	}
	
//	@RequestMapping(value = "/normal/list",method = RequestMethod.GET)
//	public String showNormalInformList(HttpSession session,
//									   ModelMap map) {
//		
//		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
//		List<NotificationMainPage> notificationList = 
//		notificationBiz.notificationNewMeeting(userSession.getUserId(), userSession.getRole().getId());
//		
//		map.addAttribute("notiList",notificationList);
//		
//		return "inform_list_show";
//	}
	
	@RequestMapping(value = "/normal/list",method = RequestMethod.GET)
	public String showNormalInformList(HttpSession session,
									   ModelMap map) {
		
		
		List<NotificationMainPage> notificationList = new ArrayList<NotificationMainPage>();
		
		NotificationMainPage n = new NotificationMainPage();
		n.setNotificationId(17);
		n.setNotificationType("新会议");
		n.setReferMsg("srtp开会");
		
		NotificationMainPage m = new NotificationMainPage();
		m.setNotificationId(2);
		m.setNotificationType("报修");
		m.setReferMsg("逸夫楼601");
		
		notificationList.add(n);
		notificationList.add(m);
		
		map.addAttribute("notiList",notificationList);
		
		return "inform_list_show";
	}
	
	
}
