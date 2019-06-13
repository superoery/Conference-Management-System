package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：登录系统-显示主界面-返回一般通知列表
 *
 */
public class NotificationMainPage implements Comparable<NotificationMainPage>{

	public Integer notificationId;
	
	private String notificationType;
	
	private String referMsg;
	
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(NotificationMainPage o) {
		// TODO Auto-generated method stub
		
		int result = o.getStatus().compareTo(this.getStatus());
		
		return result;
	}
}
