package team.softwarede.confersys.entity;

public class EquipmentType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_type.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column equipment_type.type_name
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private String typeName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_type.id
     *
     * @return the value of equipment_type.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_type.id
     *
     * @param id the value for equipment_type.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column equipment_type.type_name
     *
     * @return the value of equipment_type.type_name
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column equipment_type.type_name
     *
     * @param typeName the value for equipment_type.type_name
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}