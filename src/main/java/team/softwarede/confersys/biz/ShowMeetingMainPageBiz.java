package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumIdentity;

public interface ShowMeetingMainPageBiz {
//	List<MeetingMainPage> showParticipatedMeeting(String userId, int roleId);
	
    BasicSession getBasicSession(String userId);

	List<MeetingMainPage> showMeetingMainPage(String userId, int roleId);

}
