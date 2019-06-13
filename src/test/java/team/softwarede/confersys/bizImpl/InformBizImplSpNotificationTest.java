package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ch.qos.logback.classic.Logger;
import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.NotificationSpIntro;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformBizImplSpNotificationTest {
	@Autowired
	InformBiz informBiz;

//	@Test
//	public void test() {
//		List<NotificationSpIntro> list = informBiz.spNotificastion(3);
//		for(NotificationSpIntro intro:list) {
//			System.out.println((intro.getUserId()));
//			System.out.println(String.valueOf(intro.getReferId()));
//			System.out.println(intro.getNotificationSpType());
//		}
//	}

}
