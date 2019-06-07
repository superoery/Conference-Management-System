package team.softwarede.confersys.bizImpl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ShowMtRoomInfoBiz;
import team.softwarede.confersys.entity.MeetingRoom;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ShowMtRoomImplTest {

	@Autowired
	ShowMtRoomInfoBiz showMtRoomInfoBiz;
	@Test
	public void test() {
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom = showMtRoomInfoBiz.showMtRoomInfo(1);
		Logger logger = Logger.getLogger(getClass());
		logger.info(meetingRoom.getId());
		logger.info(meetingRoom.getBuilding());
		logger.info(meetingRoom.getFloor());
		logger.info(meetingRoom.getRoomNumber());
		logger.info(meetingRoom.getRoomIntroduce());
		logger.info(meetingRoom.getCapacity());
		logger.info(meetingRoom.getStatusId());
	}

}
