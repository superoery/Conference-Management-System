package team.softwarede.confersys.dto;

import java.util.Date;

import team.softwarede.confersys.enums.EnumNotificationSpType;

public class NotificationSpIntro {
	
	private String userId;
	
	private String applicantName;
	
	private Integer referId;
	
	private String notificationSpType;
	
	private Date applyTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Integer getReferId() {
		return referId;
	}

	public void setReferId(Integer referId) {
		this.referId = referId;
	}

	public String getNotificationSpType() {
		return notificationSpType;
	}

	public void setNotificationSpType(String notificationSpType) {
		this.notificationSpType = notificationSpType;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	

}
