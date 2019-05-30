/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.dto.UserLogin;

/**
 * @author Mity1299
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserBiz userBiz;
    
    @RequestMapping("/login")
    public String showLoginPage() {
        return "login";//页面名
    }
    
    @RequestMapping("/main")
    public String showMainPage() {
        return "main";//页面名
    }
    
    @RequestMapping("/login.do")
    public String login(ModelMap map,
                        @Valid @ModelAttribute("user") UserLogin userlogin,
                        BindingResult bindResult
                        ) {
        if(bindResult.hasErrors()) {
            return "login";//注意，这里写的是要返回的页面名，而不是路径名
        }
        String msg=null;
        msg = userBiz.login(userlogin.getUserId(), 
                      userlogin.getIdeId(), 
                      userlogin.getPassword());
        if(msg.equals("ok")) {
            return "redirect:/user/main";
        }else {
            return "redirect:/user/login";
        }
    }
}
