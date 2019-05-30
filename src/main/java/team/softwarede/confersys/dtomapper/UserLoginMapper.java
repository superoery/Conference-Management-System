package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.UserLogin;


@Mapper
public interface UserLoginMapper {

    UserLogin selectByPrimaryKey(@Param("userId")String userId,@Param("ideId")Integer ideId);
    //UserLogin selectByPrimaryKey(String userId,Integer ideId);
}