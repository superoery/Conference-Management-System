package team.softwarede.confersys.mapper;

import team.softwarede.confersys.entity.User;

public interface UserMapper {


    int deleteByPrimaryKey(String workerId);


    int insert(User record);


    int insertSelective(User record);


    User selectByPrimaryKey(String workerId);
    
    /**
     * 根据用户身份和用户编号查找用户
     * @param uId 用户编号
     * @param identityId 用户身份
     * @return 用户类
     */
    User selectByIdByIdentityId(Integer uId,Integer identityId);



    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);
}