package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.Meeting;

@Mapper
public interface MeetingMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
    
    int updateStatusById(@Param("id")Integer id,@Param("meetingStatusId")String status);
    
}