package team.softwarede.confersys.bizImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.LeaveApplicationBiz;
import team.softwarede.confersys.dto.LeaveApplyShowDetail;
import team.softwarede.confersys.dtomapper.LeaveApplyShowDetailMapper;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.mapper.LeaveApplicationMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("leaveApplicationBiz")
public class LeaveAplicationBizImpl implements LeaveApplicationBiz{
	
	@Autowired
	LeaveApplicationMapper leaveApplicationMapper;
	
	@Autowired
	NotificationMapper notificationMapper;
	@Autowired
	LeaveApplyShowDetailMapper leaveApplyShowDetailMapper; 
	
	@Transactional
	@Override
	public String submitLeaveApplication(LeaveApplication record) {
		String msg;
		String status = EnumApplyStatusId.EXAMING.getDescription();
		record.setApplyStatusId(status);
		Date applyTime = new Date();
		record.setApplyTime(applyTime);
		msg = "succeed";
		
		leaveApplicationMapper.insertSelective(record);
		
		return msg;
	}

	@Override
	public LeaveApplyShowDetail showLeaveApplylDetails(String applicantId, Integer meetingId) {
		// TODO Auto-generated method stub
		return leaveApplyShowDetailMapper.selectByUIdMtId(applicantId, meetingId);
	};

}
