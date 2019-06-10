package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingDetail;
/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface ShowMeetingDetail2Mapper {
//	MeetingDetail selectByMeetingId(@Param("meetingId")int meetingId);
	
	MeetingDetail selectByMeetingId(@Param("userId")String userId, @Param("meetingId")int meetingId);
	MeetingDetail selectByAdmin(@Param("meetingId")int meetingId);
	
	
}
