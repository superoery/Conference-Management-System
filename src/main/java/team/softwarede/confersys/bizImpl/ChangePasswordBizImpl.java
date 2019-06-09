package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ChangePasswordBiz;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.UserMapper;

@Service("ChangePasswordBiz")
public class ChangePasswordBizImpl implements ChangePasswordBiz{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public String changePassword(User user, String oldPassword, String newPassword) {
		String msg;
		
		if(oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			userMapper.updateByUserId(user);
			msg = "修改成功";
		}else {
			msg = "您的密码输入有误，请重新输入";
		}
		return msg;
	}
}
