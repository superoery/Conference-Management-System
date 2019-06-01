package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.Notification;

@Mapper
public interface NotificationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
    
    int updateStatusByPrimaryKey(@Param("id")Integer informId,
                                 @Param("notificationnStatus")String status);    
}