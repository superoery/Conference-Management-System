package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.NotificationMainPage;

public interface NotificationBiz {
	List<NotificationMainPage> notificationNewMeeting(String userId);
}
