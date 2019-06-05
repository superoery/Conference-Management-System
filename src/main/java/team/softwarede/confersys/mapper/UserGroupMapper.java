package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.BelongsToKey;
import team.softwarede.confersys.entity.UserGroup;

@Mapper
public interface UserGroupMapper {
    
    
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);
    
    UserGroup selectByPrimaryKey(Integer id);
    
    List<UserGroup> selectByCreaterId(String createrId); 

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
    
    
    
}