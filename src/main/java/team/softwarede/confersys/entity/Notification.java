package team.softwarede.confersys.entity;

public class Notification {

	private Integer id;

	private String notificationType;

	private String notificationDetail;

	private String notificationStatus;

	private Integer referId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationDetail() {
		return notificationDetail;
	}

	public void setNotificationDetail(String notificationDetail) {
		this.notificationDetail = notificationDetail;
	}

	public String getNotificationnStatus() {
		return notificationStatus;
	}

	public void setNotificationnStatus(String notificationnStatus) {
		this.notificationStatus = notificationnStatus;
	}

	public Integer getReferId() {
		return referId;
	}

	public void setReferId(Integer referId) {
		this.referId = referId;
	}
}