package com.didispace;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.didispace.entity.User;
import com.didispace.mapper.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		User user = new User();
		user.setId(10);
		user.setAge(10);
		user.setName("robot");
		userMapper.insert(user);
		User u = userMapper.selectByPrimaryKey(10);
		System.out.println(user.getName());
		Assert.assertEquals(10, u.getAge().intValue());
	}
	
	@Test
	@Rollback
	public void findById() throws Exception {

		User u=userMapper.selectByPrimaryKey(1);
		System.out.println(u.getName());
		
	}

}