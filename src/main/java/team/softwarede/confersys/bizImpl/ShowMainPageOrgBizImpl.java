package team.softwarede.confersys.bizImpl;
/**
 * 
 * @author SunRonglin
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMainPageOrgBiz;
import team.softwarede.confersys.dto.MeetingMainPage;
import team.softwarede.confersys.dtomapper.ShowMeetingMainPageMapper;
@Service("ShowMainPageOrgBiz")
public class ShowMainPageOrgBizImpl implements ShowMainPageOrgBiz{
	@Autowired
	ShowMeetingMainPageMapper showMeetingMainPageMapper;
	
	@Override
	public List<MeetingMainPage> showMainPageOrg(String userId, int roleId){
		if(roleId == 1) {
			List<MeetingMainPage> mmpList = showMeetingMainPageMapper.selectByOrgId(userId);
			return mmpList;
		}else {
			return null;
		}
	}
}
