package team.softwarede.confersys.dto;

public class NotificationMainPage {

	private Integer notificationId;
	
	private String notificationType;
	
	private String referMsg;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getReferMsg() {
		return referMsg;
	}

	public void setReferMsg(String referMsg) {
		this.referMsg = referMsg;
	}
}
