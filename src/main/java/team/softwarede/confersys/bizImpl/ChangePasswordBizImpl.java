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
	
//	@Override
//	public String changePassword(User user, String oldPassword, String newPassword) {
//		String msg;
//		String oldPasswordInDatabase = userMapper.selectPasswordByUserId(user.getUserId());
//		if(oldPassword.equals(oldPasswordInDatabase)) {
//			
//			user.setPassword(newPassword);
//			userMapper.updateByUserId(user);
//			User user1 = userMapper.selectByPrimaryKey(user.getUserId());
//			System.out.println(user1.getPassword());
//			msg = "修改成功";
//		}else {
//			msg = "您的密码输入有误，请重新输入";
//		}
//		return msg;
//	}
	
	@Override
	public String changePassword(User user, String oldPassword, String newPassword) {
		String msg;
		String userId = user.getUserId();
		String oldPasswordInDatabase = userMapper.selectPasswordByUserId(userId);
		if(oldPassword.equals(oldPasswordInDatabase)) {
			User newUser = new User();
			
			newUser.setUserId(userId);
			newUser.setPassword(newPassword);
			
			userMapper.updateByPrimaryKeySelective(newUser);
//			userMapper.updateByUserId(newUser);
			msg = "修改成功";
		}else {
			msg = "您的密码输入有误，请重新输入";
		}
		return msg;
	}
}
