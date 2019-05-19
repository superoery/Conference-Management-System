/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import team.softwarede.confersys.biz.UserBiz;

/**
 * @author Mity1299
 *
 */
public class UserBizImplTest {

    @Autowired
    UserBiz userBiz;
    
    @Test
    public void test() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testLogin() {
        
        assertEquals("ok", userBiz.login(1, 1, "123"));
    }

}
