package team.softwarede.confersys.biz;

import team.softwarede.confersys.dto.LeaveApplyShowDetail;
import team.softwarede.confersys.entity.LeaveApplication;
/**
 * 
 * @author SunRonglin
 *
 */
public interface LeaveApplicationBiz {
	
	String submitLeaveApplication(LeaveApplication record);
	
	LeaveApplyShowDetail showLeaveApplylDetails(String applicantId,Integer meetingId);

}
