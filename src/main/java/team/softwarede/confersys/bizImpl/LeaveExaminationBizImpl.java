package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.LeaveExaminationBiz;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.mapper.LeaveApplicationMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
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
	
	@Override
	public String leaveExamination(LeaveApplication record, Integer result) {
		String msg;
		Notification notification = new Notification();
		notification.setNotificationType(EnumNotificationType.LEAVE.getDescription());
		notification.setReferId(record.getMeetingId());
		notification.setNotificationnStatus(EnumNotificationStatus.UNREAD.getDescription());
		notification.setId(null);
		//result=0申请不通过，result=1申请通过
		if(result == 0) {
			record.setApplyStatusId(EnumApplyStatusId.FAILED.getDescription());
			leaveApplicationMapper.updateLeaveStatus(record);
			notification.setNotificationDetail("对不起，您的请假申请未通过。");
			
		}else {
			record.setApplyStatusId(EnumApplyStatusId.SUCCEED.getDescription());
			leaveApplicationMapper.updateLeaveStatus(record);
			notification.setNotificationDetail("恭喜，您的请假申请已通过");
		}
		notificationMapper.insert(notification);
		msg = "SUCCEED!";
		return msg;
	}
}
