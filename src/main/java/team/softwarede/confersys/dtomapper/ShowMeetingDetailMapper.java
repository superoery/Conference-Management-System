package team.softwarede.confersys.dtomapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.ParticipantBasicInfo;

/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface ShowMeetingDetailMapper {
	List<ParticipantBasicInfo> selectByMeetingId(@Param("meetingId")int meetingId);
}
