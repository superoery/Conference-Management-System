package team.softwarede.confersys.dtomapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.NotificationMainPage;

@Mapper
public interface NotificationMainPageMapper {
	
	List<NotificationMainPage> selectByUserId(@Param("userId")String userId);
}
