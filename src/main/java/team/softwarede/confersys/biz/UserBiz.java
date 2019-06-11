/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.UserInfo;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumIdentity;

/**
 * @author Mity1299
 *
 */
public interface UserBiz {

    String login(String userId,Integer identityId,String passwd);
    
    List<EnumIdentity> showLoginPage();
    
    //显示个人信息
    UserInfo showUserInfo(String userId);

}
