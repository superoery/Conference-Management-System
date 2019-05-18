/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录模块的控制器，内容包括：
 * 1. 显示主界面
 * 2. 登录
 * 3. 修改密码
 * 4. 个人信息修改
 * @author Mity1299
 */
@Controller
public class UserController {
    
    
    public String dologin(@RequestParam("userId") String userId,
                          @RequestParam("roleId") String roleId,
                          @RequestParam("passwd") String passwd) {
        
        return "login.jsp";
    }
    
    
}
