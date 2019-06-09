package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingMainPage;

public interface ShowMainPageOrgBiz {
	List<MeetingMainPage> showMainPageOrg(String userId, int roleId);
}
