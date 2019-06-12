package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Equipment;

@Mapper
public interface EquipmentMapper {

	int deleteByPrimaryKey(Integer equipmentId);

	int insert(Equipment record);

	int insertSelective(Equipment record);

	Equipment selectByPrimaryKey(Integer equipmentId);

	int updateByPrimaryKeySelective(Equipment record);

	int updateByPrimaryKey(Equipment record);
	
	int selectRoomId(int equipmentId);
	
	String selectEquipmentName(int equipmentId);
}