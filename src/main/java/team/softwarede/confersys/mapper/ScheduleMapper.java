package team.softwarede.confersys.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mysql.fabric.xmlrpc.base.Data;

import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.entity.ScheduleKey;

@Mapper
public interface ScheduleMapper {

    int deleteByPrimaryKey(ScheduleKey key);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(ScheduleKey key);

    List<Schedule> selectByDate(Date beginTime);
    
    Schedule selectByMtId(Integer meetingId);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
    
    int updateByMtIdSelective(Schedule record);
    
    List<Schedule> selectByMeetingRoom(@Param("meetingRoomId")int meetingRoomId);
    
}