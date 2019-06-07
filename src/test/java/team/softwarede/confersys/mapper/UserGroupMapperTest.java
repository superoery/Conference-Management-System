/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.UserGroup;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserGroupMapperTest {

    @Autowired
    UserGroupMapper userGroupMapper;
    
    
    @Test
    public void testSys() {
        List<UserGroup> uGroupList = userGroupMapper.selectByCreaterId("10000003");
        
        assertEquals(5, uGroupList.size());
    }
    
    
    @Test
    public void testDiy() {
        List<UserGroup> uGroupList = userGroupMapper.selectByCreaterId("10000007");
        
        assertEquals(1, uGroupList.size());
    }

}
