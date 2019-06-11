package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.EquipmentRepairDetails;

@Mapper
public interface EquipmentRepairDetailsMapper {
	EquipmentRepairDetails showEquipmentDetail(@Param("repairId")int repairId);
}
