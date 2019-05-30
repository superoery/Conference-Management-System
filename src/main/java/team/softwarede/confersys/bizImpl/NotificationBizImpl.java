package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.NotificationBiz;
import team.softwarede.confersys.dto.NotificationMainPage;
import team.softwarede.confersys.dtomapper.NotificationMainPageMapper;

@Service("NotificationBiz")
public class NotificationBizImpl implements NotificationBiz {
	
	@Autowired
	NotificationMainPageMapper notificationMapper;
	

	@Override
	public List<NotificationMainPage> notificationNewMeeting(int notificationId){
		String msg = null;
		
		NotificationMainPage notificationmainpage = notificationMapper.selectByNotificationId(notificationId);
		if(List<NotificationMainPage> == null) {
			return null;
		}else {
			return List<NotificationMainPage>;
		}
		
		
	}
	
}
