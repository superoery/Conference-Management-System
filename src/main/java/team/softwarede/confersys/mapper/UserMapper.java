package team.softwarede.confersys.mapper;

import team.softwarede.confersys.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);
    
    /**
     * 根据用户身份和用户编号查找用户密码
     * @param record
     * @return
     */
    String selectPasswdByIdByIdentityId(String uid,Integer identityId);
    
    int updateByPrimaryKeySelective(User record);

 
    int updateByPrimaryKey(User record);
}