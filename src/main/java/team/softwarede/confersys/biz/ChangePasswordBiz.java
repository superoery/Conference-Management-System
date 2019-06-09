package team.softwarede.confersys.biz;

import team.softwarede.confersys.entity.User;

public interface ChangePasswordBiz {
	String changePassword(User user, String oldPassword, String newPassword);
}
