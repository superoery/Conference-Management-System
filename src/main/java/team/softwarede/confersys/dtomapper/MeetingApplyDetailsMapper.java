package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingApplyDetails;

/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface MeetingApplyDetailsMapper {
	MeetingApplyDetails selectByMeetingId(@Param("applyId")int applyId);
}
