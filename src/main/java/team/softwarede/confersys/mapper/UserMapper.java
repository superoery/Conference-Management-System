package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.User;

@Mapper
public interface UserMapper {
 
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}