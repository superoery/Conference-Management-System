package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.EquipmentType;

@Mapper
public interface EquipmentTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentType record);

    int insertSelective(EquipmentType record);

    EquipmentType selectByPrimaryKey(Integer id);
    
    List<EquipmentType> selectAll();

    int updateByPrimaryKeySelective(EquipmentType record);

    int updateByPrimaryKey(EquipmentType record);
}