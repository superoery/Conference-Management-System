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
import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.NotificationMainPage;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformBizImplOrdinaryNotificationTest {

	@Autowired
	InformBiz informBiz;
	//显示一般通知
	@Test
	public void test() {
		String userId = "10000002";
		int roleId = 1;
		List<NotificationMainPage> list = informBiz.ordinaryNotification(userId, roleId);
		Logger logger = Logger.getLogger(getClass());
		for(NotificationMainPage str : list) {
			logger.info(str.getNotificationId());
			logger.info(str.getNotificationType());
			logger.info(str.getReferMsg());
		}

	}

}
