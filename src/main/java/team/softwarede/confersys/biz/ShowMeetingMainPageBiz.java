package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.entity.Role;

public interface ShowMeetingMainPageBiz {
	List<MeetingMainPage> showMeetingMainPage(String userId, int roleId);
	
    BasicSession getBasicSession(String userId);
    
    

}
