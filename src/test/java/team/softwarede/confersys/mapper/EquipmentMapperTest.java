/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Equipment;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EquipmentMapperTest {

    @Autowired
    EquipmentMapper equipmentMapper;
    
    @Test
    public void test() {
        Equipment equipment = new Equipment(); 
        equipment.setEquipmentName("投影仪1");
        
        
    }

}
