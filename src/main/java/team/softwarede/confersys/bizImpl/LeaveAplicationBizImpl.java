package team.softwarede.confersys.bizImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.LeaveApplicationBiz;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.mapper.LeaveApplicationMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("leaveApplicationBiz")
public class LeaveAplicationBizImpl implements LeaveApplicationBiz{
	
	@Autowired
	LeaveApplicationMapper leaveApplicationMapper;
	
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
	};

}
