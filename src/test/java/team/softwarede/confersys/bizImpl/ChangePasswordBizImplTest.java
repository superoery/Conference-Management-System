package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Test
	public void test() {
		User user = new User();
		User userNew = new User();
		String newPasswd = "5463765";
		String oldPaswd=null;
		String realPasswd=null;
		
		user = userMapper.selectByPrimaryKey("00000011");
		oldPaswd = user.getPassword();
		
		
		changePasswordBiz.changePassword(user,oldPaswd,newPasswd);
		userNew = userMapper.selectByPrimaryKey("00000011");
		
		
		realPasswd = userNew.getPassword();
		
		System.out.println("原密码："+oldPaswd);
		System.out.println("新密码："+newPasswd);
		System.out.println("真密码："+realPasswd);

		
		assertNotEquals(oldPaswd, realPasswd);
		assertEquals(newPasswd, realPasswd);
		
		
	}
	
	@Ignore
	public void testUser() {
		User user = userMapper.selectByPrimaryKey("00000011");

		System.out.println();
	}

}
