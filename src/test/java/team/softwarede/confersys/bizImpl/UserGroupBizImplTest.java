/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.Application;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserGroupBizImplTest {

    @Autowired
    UserGroupBiz userGroupBiz; 
    
    private Logger logger;
    
    @Before
    public void setUp() {
         logger = Logger.getLogger(getClass());
    }
    
    @Test
    public void test() {
        String keyword = "老师";
        String organizerId = "10000003";
        List<UserAndGroup> totalList =
                userGroupBiz.searchUAndUGByKeyword(keyword, organizerId);
        
        
        for (UserAndGroup ug : totalList) {
            logger.info(ug.getName());
        }
        
        assertEquals(4, totalList.size());
        
    }

}
