package team.softwarede.confersys.dtomapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingDetailWithoutParticipantsList;

/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface ShowMeetingDetail3Mapper {
	MeetingDetailWithoutParticipantsList normalSelectByMeetingId(@Param("meetingId")int meetingId);

}
