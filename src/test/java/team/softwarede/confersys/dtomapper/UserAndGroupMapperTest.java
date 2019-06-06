/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dtomapper;

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
import team.softwarede.confersys.dto.UGroupSearch;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserSearch;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserAndGroupMapperTest {

    
    @Autowired
    UserAndGroupMapper userAndGroupMapper;
    
    /**
     * 测试根据关键词查找用户，这里的匹配项是用户编号
     */
    @Ignore
    public void testUId() {
        String keyword = "4";
        List<UserSearch> userList = userAndGroupMapper.selectUserFuzzyBykeyword(keyword);
        
        System.out.println("testUId:"+userList.get(0).getName()); 
        
        assertEquals(1, userList.size());
        
    }
    
    
    /**
     * 测试根据关键词查找用户，这里的匹配项是用户名称
     */
    @Ignore
    public void testUName() {
        String keyword = "老师";
        List<UserSearch> userList = userAndGroupMapper.selectUserFuzzyBykeyword(keyword);
        
        assertEquals(3, userList.size());
        
    }
    
    /**
     * 测试根据关键词查找用户组，这里的匹配项是用户组编号
     */
    @Ignore
//    public void testUGroupId() {
//        String keyword = "8";
//        String userId = "10000001";
//        List<UGroupSearch> userList = userAndGroupMapper.selectGroupFuzzyBykeyword(userId, keyword);
//        
////        assertEquals(6, userList.get(0).getId());
//        assertEquals(1, userList.size());
//        
//    }
    
    @Test
    public void testUGroupName() {
        String keyword = "组";
        List<String> createrIdList = new ArrayList<String>();
        createrIdList.add("10000003");
        createrIdList.add("10000007");
        createrIdList.add("10000012");
        List<UGroupSearch> userList = userAndGroupMapper.selectGroupFuzzyBykeyword(createrIdList, keyword);
        
        assertEquals(6, userList.size());
        
    }


}
