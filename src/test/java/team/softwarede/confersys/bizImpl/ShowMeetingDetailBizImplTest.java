package team.softwarede.confersys.bizImpl;

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
import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
/**
 * 
 * @author SunRonglin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ShowMeetingDetailBizImplTest {

	@Autowired
	ShowMeetingDetail2Biz showMeetingDetail2Biz;
	//测试普通用户返回的会议详情
	
	@Transactional
	@Test
	public void testAdminShowMeetingDetail() {
		int meetingId = 21;
		int roleId = 2;
		String userId = "10000003";
		Logger logger = Logger.getLogger(getClass());
		
		MeetingDetail list = showMeetingDetail2Biz.showMeetingDetail2(userId, meetingId, roleId);
		
		List<ParticipantBasicInfo> personList = showMeetingDetail2Biz.showMeetingDetail(meetingId, roleId);

		for(ParticipantBasicInfo str : personList) {
			logger.info(str.getMtId());
			logger.info(str.getParticipantId());
			logger.info(str.getParticipantName());
			logger.info(str.getParticipantStatus());
		
		}
		logger.info(list.getMtId());
		logger.info(list.getMtTopic());
	}
}

