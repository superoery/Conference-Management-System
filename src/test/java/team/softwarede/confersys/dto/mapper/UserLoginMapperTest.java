/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dto.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.dtomapper.UserLoginMapper;


/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserLoginMapperTest {

    @Autowired
    UserLoginMapper userLoginMapper;
    
    @Test
    public void test() {
        UserLogin userLogin = userLoginMapper.selectByPrimaryKey("1", 1);
        assertEquals("123456", userLogin.getPassword());
        
    }

}
