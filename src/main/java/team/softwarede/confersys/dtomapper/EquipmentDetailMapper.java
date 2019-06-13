package team.softwarede.confersys.dtomapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.EquipmentDetail;

/**
 * 
 * @author SunRonglin
 *
 */
@Mapper
public interface EquipmentDetailMapper {
	EquipmentDetail selectByEquipmentId(@Param("equipmentId")int equipmentId);
}
