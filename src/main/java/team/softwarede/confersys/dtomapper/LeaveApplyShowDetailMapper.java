package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.LeaveApplyShowDetail;

@Mapper
public interface LeaveApplyShowDetailMapper {

	LeaveApplyShowDetail selectByUIdMtId(@Param("userId")String userId,
										 @Param("meetingId")Integer meetingId);
	
}

