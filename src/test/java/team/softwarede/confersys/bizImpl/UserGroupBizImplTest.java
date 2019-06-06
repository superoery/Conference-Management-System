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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.UserGroupCreate;
import team.softwarede.confersys.entity.UserGroup;
import team.softwarede.confersys.mapper.UserGroupMapper;

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
    @Autowired
    UserGroupMapper userGroupMapper;
    
    
    /**
     * 测试创建用户组
     */
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
    @Ignore
    public void testAdminUGroup() {
        List<UserGroup> sysUGroupList = userGroupBiz.showSySUgroup();
        
        assertEquals(6, sysUGroupList.size());
        
       
    }
    
    /**
     * 测试管理员创建的用户组列表，测试缓存
     * 如果createUGroup方法的清除缓存删掉的话，这里的测试就无法通过
     * 
     */
    @Transactional
    @Rollback
    @Test
    public void testAdminUGroupCache() {
        int listSize = 6;
        
        UserGroupCreate uGroupCreate = new UserGroupCreate();
        uGroupCreate.setCreatorId("10000012");
        uGroupCreate.setUserIdList(null);
        uGroupCreate.setUserGroupName("新的用户组");
        
        
        List<UserGroup> sysUGroupList = userGroupBiz.showSySUgroup();
        
        assertEquals(listSize, sysUGroupList.size());
        

        List<UserGroup> sysUGroupList2 = userGroupBiz.showSySUgroup();

        assertEquals(listSize, sysUGroupList2.size());
        
        userGroupBiz.createUGroup(uGroupCreate);

                
        List<UserGroup> sysUGroupList3 = userGroupBiz.showSySUgroup();

        assertEquals(listSize+1, sysUGroupList3.size());


    }
    
    
    /**
     * 测试会议组织者创建的用户组列表
     */
    @Ignore
    public void testDiyUGroup() {
        List<UserGroup> sysUGroupList = userGroupBiz.showDiyUGroup("10000007");
        
        assertEquals(2, sysUGroupList.size());
    }
    
    /**
     * 测试删除用户组
     */
    @Ignore
    public void testDeleteUGroup() {
        userGroupBiz.deleteUGroup(14);
        
        UserGroup uGroup = userGroupMapper.selectByPrimaryKey(14);
        
        assertEquals(null, uGroup);
        
        
    }
    

}
