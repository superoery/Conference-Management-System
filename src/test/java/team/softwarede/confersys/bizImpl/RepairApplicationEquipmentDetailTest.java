package team.softwarede.confersys.bizImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.EquipmentDetail;
import team.softwarede.confersys.dtomapper.EquipmentDetailMapper;
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
	@Test
	public void test() {
		int equipmentId = 13;
		EquipmentDetail detail = equipmentDetailMapper.selectByEquipmentId(equipmentId);
		System.out.println(detail.getBuilding());
	}

}
