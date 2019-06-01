package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.NotificationBiz;
import team.softwarede.confersys.dto.NotificationMainPage;
import team.softwarede.confersys.dtomapper.NotificationMainPageMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("notificationBiz")
public class NotificationBizImpl implements NotificationBiz {
	
	@Autowired
	NotificationMainPageMapper notificationMapper;
	

	@Override
	public List<NotificationMainPage> notificationNewMeeting(String userId, int roleId){
		String msg = null;
		List<NotificationMainPage> NotificationMainPage = notificationMapper.selectByUserId(userId);
		if(NotificationMainPage == null) {
			return null;
		}else {
			return NotificationMainPage;
		}
		
		
	}
	
}
