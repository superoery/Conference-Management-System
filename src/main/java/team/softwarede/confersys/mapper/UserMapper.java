package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.User;

@Mapper
public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	int deleteByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	User selectByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	int updateByPrimaryKey(User record);
}