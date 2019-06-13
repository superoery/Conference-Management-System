/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.apache.log4j.Logger;
import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.enums.EnumIdentity;
import team.softwarede.confersys.enums.EnumSex;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    

    @Ignore
    public void initUsers() { 
        
       
        User uTeacher = new User();
        uTeacher.setUserId("00000012");
        uTeacher.setIdentityId(EnumIdentity.TEACHER.getValue());
        uTeacher.setName("王教师");
        uTeacher.setSex(EnumSex.MALE.getDescription());
        uTeacher.setPassword("123");
        uTeacher.setEmail("8080@qq.com");
        uTeacher.setTelephone("19828835722");
        
        userMapper.insertSelective(uTeacher);
        
        
        
        
    }
    @Ignore
    public void changePassword() {
    	String userId = "00000009";
    	User user = userMapper.selectByPrimaryKey(userId);
    	user.setPassword("123");
    	userMapper.updateByUserId(user);
    	User user1 = userMapper.selectByPrimaryKey(userId);
    	
    	Logger logger = Logger.getLogger(getClass());
    	logger.info(user1.getPassword());
    }
    
    @Test
    public void updatePasswd() {
    	User user = new User();
    	user.setUserId("00000011");
    	user.setPassword("1234");
    	
    	userMapper.updateByUserId(user);
    }
    
    
    @Test
    public void testSelect() {
    	
    	User user =  userMapper.selectByPrimaryKey("00000011");
    	
    	System.out.println(user.getUserId());
    	System.out.println(user.getPassword());
    }
    

}
