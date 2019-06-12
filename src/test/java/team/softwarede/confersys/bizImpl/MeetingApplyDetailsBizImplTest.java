package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.dto.MeetingApplyDetails;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingApplyDetailsBizImplTest {

	@Autowired
	MeetingBiz meetingBiz;
	@Test
	public void test() {
		int applyId = 2;
		MeetingApplyDetails details = meetingBiz.showMtRoomBookDetails(applyId);
		Logger logger = Logger.getLogger(getClass());
		logger.info(details.getMeetingId());
		logger.info(details.getMtTopic());
	}

}
