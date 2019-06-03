package team.softwarede.confersys.bizImpl;

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
import team.softwarede.confersys.biz.NotificationBiz;
import team.softwarede.confersys.dto.NotificationMainPage;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class NotificationBizImplTest {

	@Autowired
	NotificationBiz notificationBiz;

	@Test
	public void testNotificationMainPage() {
		String userId = "41624544";
		int roleId = 3;
		Logger logger = Logger.getLogger(getClass());
		List<NotificationMainPage> testList = new ArrayList<NotificationMainPage>();
		
		  testList = notificationBiz.notificationNewMeeting(userId,roleId);
		  
		  if(roleId == 3){
			  if(testList == null) { logger.info("无最新会议通知");
			  
			  }else {
			  
			  for(NotificationMainPage n:testList) { 
				  logger.info(n.getNotificationId());
				  logger.info(n.getNotificationType()); 
				  logger.info(n.getReferMsg()); } 
			  }
		  } else {
			  logger.info(null);
		  }

		 
	}

}
