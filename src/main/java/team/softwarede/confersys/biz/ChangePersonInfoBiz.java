package team.softwarede.confersys.biz;

import team.softwarede.confersys.entity.User;

public interface ChangePersonInfoBiz {
	String changePersonInfo(User user, String telephone, String email);
}
