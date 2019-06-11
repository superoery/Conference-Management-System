package team.softwarede.confersys.dto;

import java.util.Date;

/**
 * 
 * @author wyfca
 * 作用：会议信息管理系统-会议组织者的会议请假审批功能
 * 
 */
public class LeaveApplyShowDetail {

	private String leaveApplicationId;
	
	private String leaveApplicantName;
	
	private String leaveApplyReason;
	
	private Date leaveApplyTime;
		
	private Integer mtId;
	
	private String mtTopic;

	public String getLeaveApplicationId() {
		return leaveApplicationId;
	}

	public void setLeaveApplicationId(String leaveApplicationId) {
		this.leaveApplicationId = leaveApplicationId;
	}

	public String getLeaveApplicantName() {
		return leaveApplicantName;
	}

	public void setLeaveApplicantName(String leaveApplicantName) {
		this.leaveApplicantName = leaveApplicantName;
	}

	public String getLeaveApplyReason() {
		return leaveApplyReason;
	}

	public void setLeaveApplyReason(String leaveApplyReason) {
		this.leaveApplyReason = leaveApplyReason;
	}

	public Date getLeaveApplyTime() {
		return leaveApplyTime;
	}

	public void setLeaveApplyTime(Date leaveApplyTime) {
		this.leaveApplyTime = leaveApplyTime;
	}

	public Integer getMtId() {
		return mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public String getMtTopic() {
		return mtTopic;
	}

	public void setMtTopic(String mtTopic) {
		this.mtTopic = mtTopic;
	}
	
}
