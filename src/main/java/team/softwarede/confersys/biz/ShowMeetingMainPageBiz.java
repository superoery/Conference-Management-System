package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingMainPage;

/**
 * 
 * @author SunRonglin
 *
 */
public interface ShowMeetingMainPageBiz {
	List<MeetingMainPage> showMeetingMainPage(String userId, int roleId);
}
