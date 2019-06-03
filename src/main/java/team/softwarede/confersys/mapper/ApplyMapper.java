package team.softwarede.confersys.mapper;

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
}