package team.softwarede.confersys.mapper;

import team.softwarede.confersys.entity.UserGroup;

public interface UserGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    int insert(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    int insertSelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    UserGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    int updateByPrimaryKey(UserGroup record);
}