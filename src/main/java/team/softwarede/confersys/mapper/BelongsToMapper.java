package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.BelongsToKey;

@Mapper
public interface BelongsToMapper {
    
    List<String> selectByUGroupId(Integer uGroupId);
    
    int deleteByPrimaryKey(BelongsToKey key);

    int insert(BelongsToKey record);

    int insertSelective(BelongsToKey record);
}