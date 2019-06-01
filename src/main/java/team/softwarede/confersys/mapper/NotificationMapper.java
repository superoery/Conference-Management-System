package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Notification;

@Mapper
public interface NotificationMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Notification record);

	int insertSelective(Notification record);

	Notification selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Notification record);

	int updateByPrimaryKey(Notification record);
}