package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.NotificationMainPage;

@Mapper
public interface NotificationMainPageMapper {
	
	NotificationMainPage selectByNotificationId(@Param("notificationId")String notificationId);
}
