package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.entity.Equipment;

@Mapper
public interface EquipmentMapper {

	int deleteByPrimaryKey(Integer equipmentId);

	int insert(Equipment record);

	int insertSelective(Equipment record);

	Equipment selectByPrimaryKey(Integer equipmentId);
	
	List <Equipment> selectByMeetingRoomId(@Param("meetingRoomId")int meetingId);

	int updateByPrimaryKeySelective(Equipment record);

	int updateByPrimaryKey(Equipment record);
	
	int selectRoomId(int equipmentId);
	
	String selectEquipmentName(int equipmentId);
}