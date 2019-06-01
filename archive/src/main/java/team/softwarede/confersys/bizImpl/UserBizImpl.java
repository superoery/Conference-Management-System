/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.dtomapper.UserLoginMapper;

/**
 * @author Mity1299
 *
 */
@Service("userBiz")
public class UserBizImpl implements UserBiz {

    @Autowired
    UserLoginMapper userloginMapper;
    
    
    @Override
    public String login(String userId, Integer identityId, String passwd) {
        // TODO Auto-generated method stub
        String msg = null;
        
        //查找是否有该用户
        UserLogin userLogin = userloginMapper.selectByPrimaryKey(userId, identityId);
        if(userLogin==null) {
            msg="输入用户编号不存在";
        }else {
            //对比密码是否正确
            if(passwd.equals(userLogin.getPassword())) {
                msg="ok";
            }else {
                msg="密码错误";
            }
        }
        return msg;
    }

}
