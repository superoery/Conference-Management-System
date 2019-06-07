package team.softwarede.confersys.bizImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ChangePersonInfoBiz;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.UserMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration

public class ChangePersonInfoBizImplTest {
	@Autowired
	ChangePersonInfoBiz changePersonInfoBiz;
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void test() {
		User user = new User();
		user = userMapper.selectByPrimaryKey("41624544");
		changePersonInfoBiz.changePersonInfo(user, "18547075617", "SunRonglin97@163.com");
	}

}
