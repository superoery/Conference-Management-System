/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.UserMapper;

/**
 * @author Mity1299
 *
 */
@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    UserMapper userMapper;
    /**
     * 验证登录信息
     */
    @Override
    public String login(String userId, String identityId, String passwd) {
        // TODO Auto-generated method stub
        String msg=null;//返回信息
        
        User user = userMapper.selectByIdByIdentityId(userId, identityId);
        if(user==null) {
            msg="用户编号不存在";
        }else {
            if(passwd==user.getPassword()) {
                msg="ok";
            }else {
                msg="密码不正确";
            }
        }
        return msg;
    }

}
