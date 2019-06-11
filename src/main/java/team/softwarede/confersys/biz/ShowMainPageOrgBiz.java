package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingMainPage;

public interface ShowMainPageOrgBiz {
	//会议组织者组织的会议
	List<MeetingMainPage> showMainPageOrg(String userId, int roleId);
}
