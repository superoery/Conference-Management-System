package team.softwarede.confersys.bizImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dtomapper.ShowMeetingMainPageMapper;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.enums.EnumIdentity;
import team.softwarede.confersys.mapper.RoleMapper;

/**
 * 
 * @author SunRonglin
 *
 */

@Service("showMeetingMainPageBiz")
public class ShowMeetingMainPageBizImpl implements ShowMeetingMainPageBiz {
	@Autowired
	ShowMeetingMainPageMapper showMeetingMainPageMapper;
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public List<MeetingMainPage> showParticipatedMeeting(String userId, int roleId){
		if(roleId == 1||roleId == 2) {
			List<MeetingMainPage> meetingMainPage = showMeetingMainPageMapper.selectByUserId(userId);
			return meetingMainPage;
		}else {
			List<MeetingMainPage> meetingMainPage = showMeetingMainPageMapper.selectByAdmId();
			return meetingMainPage;	
		}
	}

    @Override
    public Role getRole(String userId) {
        // TODO Auto-generated method stub
        
        
        
        return roleMapper.selectByUId(userId);
    }

    // add by wyf 20190605
	@Override
	public List<EnumIdentity> showAllIdentities() {
		// TODO Auto-generated method stub
		List<EnumIdentity> identities = new ArrayList<EnumIdentity>();
		identities.add(EnumIdentity.STUDENT);
		identities.add(EnumIdentity.COMMITTEE);
		identities.add(EnumIdentity.TEACHER);
		identities.add(EnumIdentity.ASSISTANT);
		identities.add(EnumIdentity.ADMIN);
		return identities;
	}
}
