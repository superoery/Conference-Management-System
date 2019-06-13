package team.softwarede.confersys.bizImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomSchedule;
import team.softwarede.confersys.dto.MeetingRoomScheduleOrg;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomBizImplScheduleTest {

	@Autowired
	MeetingRoomBiz meetingRoomBiz;
	
	@Test 
	public void test() {
		List<MeetingRoomSchedule> schedule = meetingRoomBiz.showScheduleAdmin();
	List<MeetingRoomScheduleOrg> schedule1 = meetingRoomBiz.showScheduleOrg();
		Logger logger = Logger.getLogger(getClass());
		for(MeetingRoomSchedule test:schedule) {
			logger.info(String.valueOf(test.getMtId()));
			logger.info(test.getMtTopic());

			logger.info(test.getBeginTime().toString());
			logger.info(test.getEndTime().toString());
		}
		for(MeetingRoomScheduleOrg test1:schedule1) {
			logger.info((test1.getBeginTime()).toString());
			logger.info(test1.getEndTime().toString());
			System.out.println(test1.getBeginTime().toString());
		}
		
	}

}
