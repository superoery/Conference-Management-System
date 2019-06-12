package team.softwarede.confersys.mapper;

import java.util.List;

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
    
    List<LeaveApplication> selectAll();
    
    List<LeaveApplication> selectByUserId(@Param("userId")String userId);
    
    List<LeaveApplication> selectByMeetingId(@Param("meetingId")int meetingId);
    

}