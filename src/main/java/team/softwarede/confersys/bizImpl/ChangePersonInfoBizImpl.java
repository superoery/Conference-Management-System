package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ChangePersonInfoBiz;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.UserMapper;

@Service("ChangePersonInfoBiz")
public class ChangePersonInfoBizImpl implements ChangePersonInfoBiz{
	@Autowired
	UserMapper userMapper;
	@Override
	public String changePersonInfo(User user, String telephone, String email) {
		String msg;
		if(telephone != null) {
			user.setTelephone(telephone);
		}else if(email != null) {
			user.setEmail(email);
		}else {
			msg = "No change!";
			return msg;
		}
		userMapper.updateByPrimaryKey(user);
		msg = "Succeed!";
		return msg;
	}
}
