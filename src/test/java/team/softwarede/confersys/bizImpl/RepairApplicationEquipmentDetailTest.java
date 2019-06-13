package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.EquipmentDetail;
import team.softwarede.confersys.dtomapper.EquipmentDetailMapper;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.mapper.EquipmentMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RepairApplicationEquipmentDetailTest {

	@Autowired
	EquipmentDetailMapper equipmentDetailMapper;
	
	@Autowired
	EquipmentMapper equipmentMapper;
	@Test
	public void test() {
		int equipmentId = 13;
		int meetingRoomId = 7;
		List<Equipment> list = equipmentMapper.selectByMeetingRoomId(meetingRoomId);
		for(Equipment l: list) {
			System.out.println(l.getEquipmentName());
		}
		
		EquipmentDetail detail = equipmentDetailMapper.selectByEquipmentId(equipmentId);
		System.out.println(detail.getBuilding());
	}

}
