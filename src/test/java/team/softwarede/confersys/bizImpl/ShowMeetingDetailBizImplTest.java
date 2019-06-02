package team.softwarede.confersys.bizImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.biz.ShowMeetingDetail3Biz;
import team.softwarede.confersys.biz.ShowMeetingDetailBiz;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.MeetingDetailWithoutParticipantsList;
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
	ShowMeetingDetail3Biz showMeetingDetail3Biz;
	
	@Autowired
	ShowMeetingDetailBiz showMeetingDetailBiz;
	
	@Autowired
	ShowMeetingDetail2Biz showMeetingDetail2Biz;
	//测试普通用户返回的会议详情
	@Ignore
	public void testShowMeetingDetail() {
		int meetingId = 1;
		Logger logger = Logger.getLogger(getClass());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		MeetingDetailWithoutParticipantsList list = showMeetingDetail3Biz.showMeetingDetail3(meetingId);
		logger.info(String.valueOf(list.getMtId()));
		logger.info(list.getMtTopic());
		logger.info(sdf.format(list.getBeginTime()));
		logger.info(sdf.format(list.getBeginTime()));
		logger.info(list.getMtRoomNum());
		logger.info(String.valueOf(list.getMtRoomFloor()));
		logger.info(list.getMtRoomBuilding());
		logger.info(list.getMtContent());
		logger.info(list.getMtConclusion());
		logger.info(list.getMtStatus());
		logger.info(list.getMyParticipantStatus());
	}
	//打印与会人员信息列表
	@Ignore
	public void testShowMeetingParticipants() {
		int meetingId = 1;
		Logger logger = Logger.getLogger(getClass());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

		List<ParticipantBasicInfo> infoList = showMeetingDetailBiz.showMeetingDetail(meetingId);
		
		for(ParticipantBasicInfo infolist:infoList) {
			logger.info(String.valueOf(infolist.getMtId()));
			logger.info(infolist.getParticipantId());
			logger.info(infolist.getParticipantName());
			logger.info(infolist.getParticipantStatus());
		}
	}
	@Test
	public void testAdminShowMeetingDetail() {
		int meetingId = 1;
		Logger logger = Logger.getLogger(getClass());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		
		MeetingDetail list = showMeetingDetail2Biz.showMeetingDetail2(meetingId,1);

		logger.info(String.valueOf(list.getMtId()));
		logger.info(list.getMtTopic());
		logger.info(sdf.format(list.getBeginTime()));
		logger.info(sdf.format(list.getBeginTime()));
		logger.info(list.getMtRoomNum());
		logger.info(String.valueOf(list.getMtRoomFloor()));
		logger.info(String.valueOf(list.getMtNum()));
		logger.info(list.getMtRoomBuilding());
		logger.info(list.getMtContent());
		logger.info(list.getMtConclusion());
		logger.info(list.getMtStatus());
		logger.info(list.getMyParticipantStatus());
		}
	}

