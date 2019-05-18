/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.mapper.UserMapper;

/**
 * 登录模块的控制器，内容包括：
 * 1. 显示主界面
 * 2. 登录
 * 3. 修改密码
 * 4. 个人信息修改
 * @author Mity1299
 */
@Controller
@RequestMapping(value="/login")
public class UserController {
    
    @Autowired
    UserBiz userBiz;
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String dologin(@RequestParam("userId") Integer userId,
                          @RequestParam("identityId") Integer identityId,
                          @RequestParam("passwd") String passwd,
                          HttpServletRequest request) {
        
        String msg=userBiz.login(userId, identityId, passwd);
        if(msg=="ok") {
          //登录成功
            return "redirect:/login_main";
        }else {
           request.setAttribute("msg", msg);
           return "redirect:/login";
        }
    }
    
    
}
