package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.RepairsKey;

@Mapper
public interface RepairsMapper {

	int deleteByPrimaryKey(RepairsKey key);
	
	int insert(RepairsKey record);

	int insertSelective(RepairsKey record);
	
	RepairsKey selectByReEquipmentId(Integer repairEquipmentId);
	
	RepairsKey selectByRepairEquipmentId(int repairEquipmentId);
}