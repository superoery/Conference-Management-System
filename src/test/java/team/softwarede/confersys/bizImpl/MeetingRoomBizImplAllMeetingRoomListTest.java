package team.softwarede.confersys.bizImpl;

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
import team.softwarede.confersys.dto.MeetingRoomAvail;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomBizImplAllMeetingRoomListTest {

	@Autowired
	MeetingRoomBiz meetingRoomBiz;
	@Test
	public void test() {
		List<MeetingRoomAvail> mtRoomList = meetingRoomBiz.showAllMtRoom();
		Logger logger = Logger.getLogger(getClass());
		for(MeetingRoomAvail room:mtRoomList) {
			logger.info(room.getId());
			logger.info(room.getRoomNumber());
			logger.info(room.getBuilding());
			logger.info(room.getFloor());
			logger.info(room.getCapacity());
			
		}
	}

}
