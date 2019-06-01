package team.softwarede.confersys.dto;

import java.util.Date;

/**
 * 
 * @author wyfca
 * 作用：登录系统-显示主界面-返回请假列表（会议组织者主界面）
 *
 */
public class LeaveApplyNoticeMainPage {

	private Integer leaveApplicationId;
	
	private String leaveApplicantName;
	
	private Date leaveApplyTime;
	
	private String mtTopic;

	public Integer getLeaveApplicationId() {
		return leaveApplicationId;
	}

	public void setLeaveApplicationId(Integer leaveApplicationId) {
		this.leaveApplicationId = leaveApplicationId;
	}

	public String getLeaveApplicantName() {
		return leaveApplicantName;
	}

	public void setLeaveApplicantName(String leaveApplicantName) {
		this.leaveApplicantName = leaveApplicantName;
	}

	public Date getLeaveApplyTime() {
		return leaveApplyTime;
	}

	public void setLeaveApplyTime(Date leaveApplyTime) {
		this.leaveApplyTime = leaveApplyTime;
	}

	public String getMtTopic() {
		return mtTopic;
	}

	public void setMtTopic(String mtTopic) {
		this.mtTopic = mtTopic;
	}
	
}
