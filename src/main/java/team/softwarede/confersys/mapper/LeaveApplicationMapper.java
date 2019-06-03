package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.LeaveApplication;
/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface LeaveApplicationMapper {

    int deleteByPrimaryKey(Integer meetingId);

    String submitLeaveApplication(@Param("record")LeaveApplication record);

    int insertSelective(LeaveApplication record);

    LeaveApplication selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(LeaveApplication record);

    int updateByPrimaryKey(LeaveApplication record);
    
    int updateLeaveStatus(LeaveApplication record);
    

}