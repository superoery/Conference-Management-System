/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.UserGroupCreate;
import team.softwarede.confersys.entity.UserGroup;

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
    
    @Ignore
    public void test() {

        UserGroupCreate uGroupCreate = new UserGroupCreate();
        
        uGroupCreate.setCreatorId("10000007");
        uGroupCreate.setUserGroupName("阴阳师组");
        List<String> userIdList = new ArrayList<String>();
        userIdList.add("10000008");
        userIdList.add("10000009");
        uGroupCreate.setUserIdList(userIdList);
        
        userGroupBiz.createUGroup(uGroupCreate);
    }
    
    /**
     * 测试获得管理员创建的用户组列表
     */
    @Test
    public void testAdminUGroup() {
        List<UserGroup> sysUGroupList = userGroupBiz.showSySUgroup();
        
        assertEquals(7, sysUGroupList.size());
    }
    
    /**
     * 测试会议组织者创建的用户组列表
     */
    @Test
    public void testDiyUGroup() {
        List<UserGroup> sysUGroupList = userGroupBiz.showDiyUGroup("10000007");
        
        assertEquals(2, sysUGroupList.size());
    }
    

}
