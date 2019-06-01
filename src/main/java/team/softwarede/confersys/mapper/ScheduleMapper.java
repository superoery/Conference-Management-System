package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.entity.ScheduleKey;

@Mapper
public interface ScheduleMapper {

    int deleteByPrimaryKey(ScheduleKey key);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(ScheduleKey key);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
    
    int updateByMtIdSelective(Schedule record);
}