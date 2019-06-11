package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.assertEquals;

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
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ShowMainPageOrgBiz;
import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.BasicSession;
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
	
	@Autowired
	ShowMainPageOrgBiz showMainPageOrgBiz;
	
	@Transactional
	@Test
	public void testShowMeetingMainPage() {
		String userId = "00000009";
		Logger logger = Logger.getLogger(getClass());
		List<MeetingMainPage> testList = new ArrayList<MeetingMainPage>();
		List<MeetingMainPage> orgList = new ArrayList<MeetingMainPage>();
		testList = showMeetingMainPageBiz.showMeetingMainPage(userId, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		for(MeetingMainPage string : testList) {
			logger.info(String.valueOf(string.getMtId()));
			logger.info(string.getMtTopic());
			logger.info(sdf.format(string.getBeginTime()));
			logger.info(sdf.format(string.getBeginTime()));
			logger.info(string.getMtRoomBuilding());
			logger.info(String.valueOf(string.getMtRoomFloor()));
			logger.info(string.getMtRoomNum());
			logger.info(string.getMtStatus());
		}
		orgList = showMainPageOrgBiz.showMainPageOrg("00000009", 1);
		for(MeetingMainPage str : orgList) {
			logger.info(String.valueOf(str.getMtId()));
			logger.info(str.getMtTopic());
			logger.info(sdf.format(str.getBeginTime()));
			logger.info(sdf.format(str.getBeginTime()));
			logger.info(str.getMtRoomBuilding());
			logger.info(String.valueOf(str.getMtRoomFloor()));
			logger.info(str.getMtRoomNum());
			logger.info(str.getMtStatus());
		}
	}
	
	@Test
	public void testGetSession() {
	    
	    BasicSession session = showMeetingMainPageBiz.getBasicSession("10000010");
	    
	    assertEquals("会议组织者", session.getRole().getRole());
	    
	    
	}

}
