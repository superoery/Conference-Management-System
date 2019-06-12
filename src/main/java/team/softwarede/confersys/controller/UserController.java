/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

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

import team.softwarede.confersys.biz.ChangePasswordBiz;
import team.softwarede.confersys.biz.ChangePersonInfoBiz;
import team.softwarede.confersys.biz.ShowMainPageOrgBiz;
import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dto.UserInfo;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.entity.User;
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
    
    @Autowired
    ShowMainPageOrgBiz showMainPageOrgBiz;
    
    @Autowired
    ChangePersonInfoBiz changePersonInfoBiz;
    
    @Autowired
    ChangePasswordBiz changePasswordBiz;
    
	@RequestMapping("/login")
	public String index(ModelMap map, @ModelAttribute("loginForm") UserLogin userlogin,
			@ModelAttribute("msg") String msg) {
		List<EnumIdentity> identities = userBiz.showLoginPage();
		map.addAttribute("identities",identities);
		
		// attributes.addFlashAttribute将redirect前的参数放进map里
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
			
			List<MeetingMainPage> pmtList = showMeetingMainPageBiz.showMeetingMainPage(userSession.getUserId(), userSession.getRole().getId());
			map.addAttribute("pmtList",pmtList);
			
			List<MeetingMainPage> omtList = showMainPageOrgBiz.showMainPageOrg(userSession.getUserId(), userSession.getRole().getId());
			map.addAttribute("omtList",omtList);
			
			List<MeetingMainPage> amtList = showMeetingMainPageBiz.showMeetingMainPage(userSession.getUserId(), userSession.getRole().getId());
			map.addAttribute("amtList",amtList);
			
			// List<NotificationMainPage> normalNotice = showMeetingMainPageBiz.showNormalNotification(userSession.getUserId());
			return "login_main";
		}else {
			attributes.addFlashAttribute("msg",msg);
		    return "redirect:/user/login";
		}
    }
	
	@RequestMapping("/showInfo.do")
	public String showInfo(ModelMap map, 
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		UserInfo userInfo = userBiz.showUserInfo(userSession.getUserId());
		map.addAttribute("userInfo", userInfo);
		
		return "user_info";
	}
    
	@RequestMapping("/info_change.do")
	public String infoChange(ModelMap map,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		UserInfo userInfo = userBiz.showUserInfo(userSession.getUserId());
		map.addAttribute("userInfo", userInfo);
		
		return "user_info_change";
	}
	
	@RequestMapping("/info_change_submit.do")
	public String infoChangeSubmit(ModelMap map,
			@ModelAttribute("email") String email,
			@ModelAttribute("telephone") String telephone,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		User user = new User();
		user.setUserId(userSession.getUserId());
		changePersonInfoBiz.changePersonInfo(user, telephone, email);
		
		return "redirect:/user/showInfo.do";
	}
	
	@RequestMapping("/psw_change.do")
	public String pswChange(ModelMap map,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession); 
		
		return "user_psw_change";
	}
	
	@RequestMapping("/psw_change_submit.do")
	public String pswChangeSubmit(ModelMap map,
			@ModelAttribute("oldPsw") String oldPsw,
			@ModelAttribute("newPsw") String newPsw,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);

		User user = new User();
		user.setUserId(userSession.getUserId());
		
		String changeMsg = changePasswordBiz.changePassword(user, oldPsw, newPsw);
		map.addAttribute("changeMsg", changeMsg);
		
		return "user_psw_changeMsg";
	}
	
	
}
