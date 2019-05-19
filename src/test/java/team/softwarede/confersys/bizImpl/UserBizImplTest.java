/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import team.softwarede.confersys.biz.UserBiz;
import team.softwarede.confersys.entity.User;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringApplicationConfiguration(classes = MockServletContext.class) 
@WebAppConfiguration 
public class UserBizImplTest {
    
    private MockMvc mvc; 

    @Before(value = "")
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserBizImpl()).build(); 
    }
    
    @Test
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testLogin() {

        String msg =userBiz.login("1", "1","123");
        System.out.println(msg);
//        assertEquals("ok",msg);
    }

}
