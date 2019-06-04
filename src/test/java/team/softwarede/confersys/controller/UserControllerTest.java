/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import team.softwarede.confersys.Application;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mvc;
    
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    private UserController userController;
    

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }
    
    /**
     * 测试登录成功的情况
     */
    @Test
    public void testLoginSuccess() {
        try {
            mvc.perform(post("/user/login.do").
                    param("userId", "10000006").
                    param("identityId", "1").
                    param("password", "123")
                    ).
                    andExpect(redirectedUrl("/user/main"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 测试登录失败的情况
     * 当用户编号、身份编号和密码不匹配
     */
    @Ignore
    public void testLoginIlegal() {
        try {
            mvc.perform(post("/user/login.do").
                    param("userId", "1").
                    param("ideId", "1").
                    param("password", "1236")
                    ).
                    andDo(print());
                    //andExpect(redirectedUrl("/user/login"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 测试登录的数据校验
     * 输入:空的密码
     * 输出：密码为空
     * 
     */
    @Ignore
    public void testLoginValid() {
        try {
            mvc.perform(post("/user/login.do").
                    param("userId", "1").
                    param("ideId", "1")
                    ).
                    andExpect(redirectedUrl("main"));
                    //andDo(print());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
