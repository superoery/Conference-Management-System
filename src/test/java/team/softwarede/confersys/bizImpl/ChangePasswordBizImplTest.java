package team.softwarede.confersys.bizImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ChangePasswordBiz;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.UserMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ChangePasswordBizImplTest {
	@Autowired
	ChangePasswordBiz changePasswordBiz;
	
	@Autowired
	UserMapper userMapper;
	@Test
	public void test() {
		User user = new User();
		user = userMapper.selectByPrimaryKey("41624544");
		changePasswordBiz.changePassword(user,"2799","2775");
	}

}
