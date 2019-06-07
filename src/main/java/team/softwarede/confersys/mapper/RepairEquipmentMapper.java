package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.RepairEquipment;

@Mapper
public interface RepairEquipmentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RepairEquipment record);

    int insertSelective(RepairEquipment record);

    RepairEquipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepairEquipment record);

    int updateByPrimaryKey(RepairEquipment record);
}