package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dtomapper.ShowMeetingMainPageMapper;
import team.softwarede.confersys.entity.Role;
import team.softwarede.confersys.entity.User;
import team.softwarede.confersys.mapper.RoleMapper;
import team.softwarede.confersys.mapper.UserMapper;

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
	@Autowired
	UserMapper userMapper; 
	
	
	@Override
	public List<MeetingMainPage> showMeetingMainPage(String userId, int roleId){
		if(roleId == 1||roleId == 2) {
			List<MeetingMainPage> meetingMainPage = showMeetingMainPageMapper.selectByUserId(userId);
			return meetingMainPage;
		}else {
			List<MeetingMainPage> meetingMainPage = showMeetingMainPageMapper.selectByAdmId();
			return meetingMainPage;	
		}
	}

	@Transactional
    @Override
    public BasicSession getBasicSession(String userId) {
        // TODO Auto-generated method stub
        BasicSession basicSession = new BasicSession();
        
        User user = userMapper.selectByPrimaryKey(userId);
        Role role = roleMapper.selectByUId(userId);
        
        basicSession.setUserId(userId);
        basicSession.setUserName(user.getName());
        basicSession.setRole(role);
        
        return basicSession;
    }
}
