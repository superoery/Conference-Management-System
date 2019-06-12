package team.softwarede.confersys.dtomapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.LeaveApplyShowDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class LeaveApplyShowDetailMapperTest {

	@Autowired
	LeaveApplyShowDetailMapper leaveApplyShowDetailMapper;
	
	@Test
	public void test() {
		String userId = "10000005";
		Integer meetingId = 14;
		LeaveApplyShowDetail detail = leaveApplyShowDetailMapper.selectByUIdMtId(userId, meetingId);
		
		assertEquals("病假", detail.getLeaveApplyReason());
	}

}
