/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.enums.EnumIdentity;
import team.softwarede.confersys.enums.EnumRoleName;
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
    
    
    @Test
    public void initUsers() { 
        
       
        User uTeacher = new User();
        uTeacher.setUserId("000001");
        uTeacher.setIdentityId(EnumIdentity.TEACHER.getValue());
        uTeacher.setName("王教师");
        uTeacher.setSex(EnumSex.MALE.getDescription());
        uTeacher.setPassword("123");
        uTeacher.setEmail("8080@qq.com");
        uTeacher.setTelephone("19828835722");
        
        userMapper.insertSelective(uTeacher);
        
        
        
        
    }

}
