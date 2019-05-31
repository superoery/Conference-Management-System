package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：登录系统-显示主界面-返回一般通知列表
 *
 */
public class NotificationMainPage {

	public Integer notificationId;
	
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
