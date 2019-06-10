package team.softwarede.confersys.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.entity.Role;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformControllerTest {
	
    private MockMvc mvc;
    @Autowired
    protected WebApplicationContext wac;	
    
    
    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    /**
     * 测试显示一般通知的详情
     */
	@Ignore
	public void testDetails() {
		BasicSession userSession = new BasicSession();
		Role role = new Role();
		
		role.setId(3);
		role.setRole("普通用户");
		
		userSession.setRole(role);
		userSession.setUserName("小明");
		userSession.setUserId("10000002");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/inform/normal/details/17");

		requestBuilder.requestAttr("userSession", userSession);
		
		try {
			mvc.perform(requestBuilder).andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 测试显示一般通知列表
	 */
	@Ignore
	public void testList() {
		BasicSession userSession = new BasicSession();
		Role role = new Role();
		
		role.setId(3);
		role.setRole("普通用户");
		
		userSession.setRole(role);
		userSession.setUserName("小明");
		userSession.setUserId("10000002");

		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/inform/normal/list");

		requestBuilder.requestAttr("userSession", userSession);

		try {
			mvc.perform(requestBuilder).andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 测试从通知列表跳转到通知详情
	 */
	public void testListSkipDetails() {
		
	}
}
