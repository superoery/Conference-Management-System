package team.softwarede.confersys.bizImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.MeetingMainPage;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ShowMeetingMainPageBizImplTest {

	@Autowired
	ShowMeetingMainPageBiz showMeetingMainPageBiz;
	
	@Test
	public void testShowMeetingMainPage() {
		String userId = "41624544";
		Logger logger = Logger.getLogger(getClass());
		List<MeetingMainPage> testList = new ArrayList<MeetingMainPage>();
		testList = showMeetingMainPageBiz.showMeetingMainPage(userId, 2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		for(MeetingMainPage string : testList) {
			logger.info(String.valueOf(string.getMtId()));
			logger.info(string.getMtTopic());
			logger.info(sdf.format(string.getBeginTime()));
			logger.info(sdf.format(string.getBeginTime()));
			logger.info(string.getMtRoomBuilding());
			logger.info(String.valueOf(string.getMtRoomFloor()));
			logger.info(string.getMtRoomNum());
		}
	}

}
