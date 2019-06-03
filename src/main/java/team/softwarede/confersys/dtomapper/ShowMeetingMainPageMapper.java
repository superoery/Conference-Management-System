package team.softwarede.confersys.dtomapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingMainPage;

/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface ShowMeetingMainPageMapper {
	List<MeetingMainPage> selectByUserId(@Param("userId")String userId);
	List<MeetingMainPage> selectByAdmId();
}
