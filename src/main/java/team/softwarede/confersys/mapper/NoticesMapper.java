package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.NoticesKey;

@Mapper
public interface NoticesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int deleteByPrimaryKey(NoticesKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insert(NoticesKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notices
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insertSelective(NoticesKey record);
}