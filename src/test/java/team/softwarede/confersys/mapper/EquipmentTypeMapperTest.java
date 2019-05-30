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
import team.softwarede.confersys.entity.EquipmentType;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EquipmentTypeMapperTest {

    @Autowired
    EquipmentTypeMapper equipmentTypeMapper;
    
    @Test
    public void test() {
        
        EquipmentType type1 = new EquipmentType();
        type1.setTypeName("打印机");
        
        EquipmentType type2 = new EquipmentType();
        type2.setTypeName("投影仪");
        
        EquipmentType type3 = new EquipmentType();
        type3.setTypeName("电脑");
        
        EquipmentType type4 = new EquipmentType();
        type4.setTypeName("黑板");
        
        equipmentTypeMapper.insertSelective(type1);
        equipmentTypeMapper.insertSelective(type2);
        equipmentTypeMapper.insertSelective(type3);
        equipmentTypeMapper.insertSelective(type4);
        
        
        
    }

}
