package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Equipment;

@Mapper
public interface EquipmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int deleteByPrimaryKey(Integer equipmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insert(Equipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insertSelective(Equipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    Equipment selectByPrimaryKey(Integer equipmentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int updateByPrimaryKeySelective(Equipment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table equipment
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int updateByPrimaryKey(Equipment record);
}