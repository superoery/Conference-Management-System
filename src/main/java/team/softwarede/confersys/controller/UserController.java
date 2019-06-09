/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumIdentity;

/**
 * @author Mity1299
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserBiz userBiz;
    
    @Autowired
    ShowMeetingMainPageBiz showMeetingMainPageBiz;
    
	@RequestMapping("/login")
	public String index(ModelMap map, @ModelAttribute("loginForm") UserLogin userlogin,
			@ModelAttribute("msg") String msg) {
		List<EnumIdentity> identities = userBiz.showLoginPage();
		map.addAttribute("identities",identities);
		map.addAttribute("msg",msg);
        return "login";
    }
    
	@RequestMapping("/tologin.do")
	public String tologin(ModelMap map,
			@Valid @ModelAttribute("loginForm") UserLogin userlogin,
			BindingResult bindResult,
			RedirectAttributes attributes, 
			HttpSession session) {
		if(bindResult.hasErrors()) {
			List<EnumIdentity> identities = userBiz.showLoginPage();
			map.addAttribute("identities",identities);
			return "login";
		}
		String msg=null;
		msg = userBiz.login(userlogin.getUserId(), 
		              userlogin.getIdentityId(), 
		              userlogin.getPassword());
		if(msg.equals("ok")) {
			// show Main Page
			BasicSession userSession = showMeetingMainPageBiz.getBasicSession(userlogin.getUserId());
			session.setAttribute("userSession", userSession);
			map.addAttribute("userSession",userSession);
			
//			List<MeetingMainPage> pmtList = showMeetingMainPageBiz.showParticipatedMeeting(userSession.getUserId(), userSession.getRole().getId());
//			map.addAttribute("pmtList",pmtList);
//			
//			List<MeetingMainPage> omtList = showMeetingMainPageBiz.showOranizedMeeting(userSession.getUserId(), userSession.getRole().getId());
//			map.addAttribute("omtList",omtList);
//			
//			List<MeetingMainPage> amtList = showMeetingMainPageBiz.showAllMeeting(userSession.getUserId(), userSession.getRole().getId());
//			map.addAttribute("amtList",amtList);
			
			// List<NotificationMainPage> normalNotice = showMeetingMainPageBiz.showNormalNotification(userSession.getUserId());
			return "login_main";
		}else {
			attributes.addFlashAttribute("msg",msg);
		    return "redirect:/user/login";
		}
    }
    
}
