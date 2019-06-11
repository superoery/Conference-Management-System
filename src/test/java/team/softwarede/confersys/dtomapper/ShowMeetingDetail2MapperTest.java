package team.softwarede.confersys.dtomapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.entity.Meeting;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ShowMeetingDetail2MapperTest {

	
	@Autowired
	ShowMeetingDetail2Mapper showMeetingDetail2Mapper;
	
	@Test
	public void test() {
		MeetingDetail meetingDetail = showMeetingDetail2Mapper.selectByMeetingId("00000009",21);
		
		assertEquals("党团开会", meetingDetail.getMtTopic());
	}

}
