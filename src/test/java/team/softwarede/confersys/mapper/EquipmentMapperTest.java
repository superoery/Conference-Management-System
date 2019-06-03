/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mysql.fabric.xmlrpc.base.Array;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.enums.EnumEquipmentStatus;

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
    public void insertEquip() {
        Equipment equipment = new Equipment(); 
        equipment.setEquipmentName("电脑2");
        equipment.setEquipmentTypeId(3);//投影仪类型
        equipment.setMeetingRoomId(8);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());
    
        equipmentMapper.insertSelective(equipment);
    }
    
    @Ignore
    public void initEquip() {
        Integer size = 6;
        Equipment[] equipmentArray = new Equipment[size];
        Equipment equipment = new Equipment(); 
        equipment.setEquipmentName("投影仪1");
        equipment.setEquipmentTypeId(2);//投影仪类型
        equipment.setMeetingRoomId(7);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());
        
        equipmentArray[0]=equipment;
        
        equipment = new Equipment(); 
        equipment.setEquipmentName("电脑1");
        equipment.setEquipmentTypeId(3);
        equipment.setMeetingRoomId(7);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());

        equipmentArray[1]=equipment;
        equipment = new Equipment(); 
        equipment.setEquipmentName("黑板1");
        equipment.setEquipmentTypeId(4);
        equipment.setMeetingRoomId(7);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());

        equipmentArray[2]=equipment;
        
        equipment = new Equipment(); 
        equipment.setEquipmentName("投影仪2");
        equipment.setEquipmentTypeId(2);
        equipment.setMeetingRoomId(8);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());

        equipmentArray[3]=equipment;
        
        equipment = new Equipment(); 
        equipment.setEquipmentName("打印机1");
        equipment.setEquipmentTypeId(1);
        equipment.setMeetingRoomId(8);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());

        equipmentArray[4]=equipment;
        
        equipment = new Equipment(); 
        equipment.setEquipmentName("电脑2");
        equipment.setEquipmentTypeId(3);//投影仪类型
        equipment.setMeetingRoomId(7);//会议室编号
        equipment.setStoreTime(new Date());
        equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());
        
        equipmentArray[5]=equipment;


        for(Equipment e : equipmentArray) { 
            if(e!=null) {
                equipmentMapper.insertSelective(e);                 
            }
            
        }
         
        
    }

}
