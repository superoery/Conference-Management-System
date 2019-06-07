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
    
//    @RequestMapping("/login")
//    public String showLoginPage() {
//        return "login";//页面名
//    }
//    
//    @RequestMapping("/main")
//    public String showMainPage() {
//        return "main";//页面名
//    }
//    
//    @RequestMapping("/login.do")
//    public String login(ModelMap map,
//                        @Valid @ModelAttribute("user") UserLogin userlogin,
//                        BindingResult bindResult
//                        ) {
//        if(bindResult.hasErrors()) {
//            return "login";//注意，这里写的是要返回的页面名，而不是路径名
//        }
//        String msg=null;
//        msg = userBiz.login(userlogin.getUserId(), 
//                      userlogin.getIdeId(), 
//                      userlogin.getPassword());
//        if(msg.equals("ok")) {
//            return "redirect:/user/main";
//        }else {
//            return "redirect:/user/login";
//        }
//    }
    
	@RequestMapping("/login")
	public String index(ModelMap map, @ModelAttribute("loginForm") UserLogin userlogin,
			@ModelAttribute("msg") String msg) {
		List<EnumIdentity> identities = new ArrayList<EnumIdentity>();
		identities.add(EnumIdentity.STUDENT);
		identities.add(EnumIdentity.COMMITTEE);
		identities.add(EnumIdentity.TEACHER);
		identities.add(EnumIdentity.ASSISTANT);
		identities.add(EnumIdentity.ADMIN);
		map.addAttribute("identities",identities);
		map.addAttribute("msg",msg);
        return "login";
    }
    
	@RequestMapping("/tologin.do")
	public String tologin2(ModelMap map,
			@Valid @ModelAttribute("loginForm") UserLogin userlogin,
			BindingResult bindResult,
			RedirectAttributes attributes, 
			HttpSession session) {
		if(bindResult.hasErrors()) {
			return "redirect:/user/login";//注意，这里写的是要返回的页面名，而不是路径名
		}
		String msg=null;
		msg = userBiz.login(userlogin.getUserId(), 
		              userlogin.getIdentityId(), 
		              userlogin.getPassword());
		if(msg.equals("ok")) {
//			map.addAttribute("host","hello! "+userlogin.getUserId()+", identityId="+String.valueOf(userlogin.getIdentityId()));
//			return "index";
			//Role role = showMeetingMainPageBiz.getRole(userlogin.getUserId());
			List<MeetingMainPage> pmtList = showMeetingMainPageBiz.showMeetingMainPage(userlogin.getUserId(), role.getId());
			map.addAttribute("pmtList",pmtList);
			return "login_main";
		}else {
			attributes.addFlashAttribute("msg",msg);
		    return "redirect:/user/login";
		}
    }
    
}
