package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.entity.NoticesKey;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.enums.EnumParticipatesStatus;
import team.softwarede.confersys.mapper.LeaveApplicationMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.NoticesMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("leaveExaminationBiz")
public class LeaveExaminationBizImpl implements LeaveExaminationBiz{
	@Autowired
	LeaveApplicationMapper leaveApplicationMapper;
	
	@Autowired
	NotificationMapper notificationMapper;
	
	@Autowired
	NoticesMapper noticesMapper;
	
	@Autowired
	MeetingMapper meetingMapper;
	
	@Autowired
	ParticipatesMapper participatesMapper;
	
	@Transactional
	@Override
	public String leaveExamination(LeaveApplication record, Integer result) {
		String msg;
		Notification notification = new Notification();
		notification.setNotificationType(EnumNotificationType.LEAVE.getDescription());
		notification.setReferId(record.getMeetingId().toString());
		notification.setNotificationStatus(EnumNotificationStatus.UNREAD.getDescription());
		notification.setId(null);
		NoticesKey notices = new NoticesKey();
		int meetingId; 
		String topic;

		//result=0申请不通过，result=1申请通过
		if(result == 0) {
			record.setApplyStatusId(EnumApplyStatusId.FAILED.getDescription());
			leaveApplicationMapper.updateLeaveStatus(record);
			meetingId = record.getMeetingId();
			topic = meetingMapper.selectTopicById(meetingId);
			notification.setNotificationDetail("对不起，您的会议主题为" + topic + "的会议请假申请未通过");
		}else {
			record.setApplyStatusId(EnumApplyStatusId.SUCCEED.getDescription());
			leaveApplicationMapper.updateLeaveStatus(record);
			meetingId = record.getMeetingId();
			topic = meetingMapper.selectTopicById(meetingId);
			notification.setNotificationDetail("恭喜，您的会议主题为" + topic +"的会议请假申请已通过");
			participatesMapper.updateStatus(record.getUserId(), record.getMeetingId(), EnumParticipatesStatus.LEAVE.getDescription());
		}
		notificationMapper.insert(notification);
		int id = notificationMapper.selectByNotification(notification);
		
		notices.setNotificationId(id);
		notices.setUserId(record.getUserId());
		noticesMapper.insert(notices);
		msg = "SUCCEED!";
		return msg;
	}
}
