package com.didispace;

import com.didispace.domain.User;
import com.didispace.entity.User2;
import com.didispace.mapper.User2Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ApplicationTests {

	@Autowired
	private User2Mapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		User2 user = new User2();
		user.setId(10);
		user.setAge(10);
		user.setName("robot");
		userMapper.insert(user);
		User2 u = userMapper.selectByPrimaryKey(10);
		System.out.println(user.getName());
		Assert.assertEquals(10, u.getAge().intValue());
	}

}