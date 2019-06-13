package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.User;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);
    
    List<User> selectByIdentityId(Integer identityId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int updateByUserId(@Param("user")User user);
    
    String selectNameByUserId(@Param("userId")String userId);
    
    String selectPasswordByUserId(@Param("userId")String userId);
}