package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.Apply;

@Mapper
public interface ApplyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
    
    int updateByMtIdSelective(Apply record);
    
    int updateStatusById(@Param("id")Integer id,@Param("applyStatusId")String status);
    
    //显示特殊通知——会议申请
    List<Apply> selectAllApply();
    
    int selectMeetingId(@Param("userId")String userId);
}