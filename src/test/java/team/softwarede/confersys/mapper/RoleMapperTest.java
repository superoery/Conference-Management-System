/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumRoleName;
import team.softwarede.confersys.mapper.RoleMapper;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;
    
    private Logger logger = Logger.getLogger(getClass());
    
    /**
     * 测试是否可获得自增长主键
     */
    @Test
    public void testInsert() {
        Role role1 = new Role();
        role1.setRole(EnumRoleName.ADMIN.getDescription());
        role1.setId(EnumRoleName.ADMIN.getValue());
        
        Role role2 = new Role();
        role2.setRole(EnumRoleName.NORMAL.getDescription());
        role2.setId(EnumRoleName.NORMAL.getValue());
        
        Role role3 = new Role();
        role3.setRole(EnumRoleName.ORGANIZER.getDescription());
        role3.setId(EnumRoleName.ORGANIZER.getValue());
        
        roleMapper.insertSelective(role1);
        roleMapper.insertSelective(role2);
        roleMapper.insertSelective(role3);
        
//        assertEquals((Integer)1, role1.getId());
        
    }
    
    /**
     * 给枚举类型赋值的测试
     */
    @Ignore
    public void testEnum() {
        //获得自定义的值
        logger.warn(String.valueOf(EnumRoleName.ORGANIZER.getValue()));
        //获得默认值
        logger.warn(String.valueOf(EnumRoleName.ADMIN.ordinal()));
        logger.warn(String.valueOf(EnumRoleName.NORMAL.ordinal()));
        
        System.out.println("测试");
    }
    
    /**
     * 根据权限名称查找权限
     */
    @Ignore
    public void testSelectByName() {
        Role role = roleMapper.selectByName(EnumRoleName.ADMIN.toString());
        
        assertEquals((Integer)1, role.getId());
    }

}
