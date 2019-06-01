package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.NotificationMainPage;
/**
 * 
 * @author SunRonglin
 *
 */
public interface NotificationBiz {
	List<NotificationMainPage> notificationNewMeeting(String userId, int roleId);
}
