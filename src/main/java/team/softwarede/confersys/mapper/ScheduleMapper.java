package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.entity.ScheduleKey;

@Mapper
public interface ScheduleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int deleteByPrimaryKey(ScheduleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insert(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int insertSelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    Schedule selectByPrimaryKey(ScheduleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int updateByPrimaryKeySelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    int updateByPrimaryKey(Schedule record);
}