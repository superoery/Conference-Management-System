package team.softwarede.confersys.entity;

import java.util.Date;

public class Apply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.meeting_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private Integer meetingId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.user_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.apply_status_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private String applyStatusId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column apply.apply_time
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    private Date applyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.id
     *
     * @return the value of apply.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.id
     *
     * @param id the value for apply.id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.meeting_id
     *
     * @return the value of apply.meeting_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public Integer getMeetingId() {
        return meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.meeting_id
     *
     * @param meetingId the value for apply.meeting_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.user_id
     *
     * @return the value of apply.user_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.user_id
     *
     * @param userId the value for apply.user_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.apply_status_id
     *
     * @return the value of apply.apply_status_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public String getApplyStatusId() {
        return applyStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.apply_status_id
     *
     * @param applyStatusId the value for apply.apply_status_id
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setApplyStatusId(String applyStatusId) {
        this.applyStatusId = applyStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column apply.apply_time
     *
     * @return the value of apply.apply_time
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column apply.apply_time
     *
     * @param applyTime the value for apply.apply_time
     *
     * @mbg.generated Thu May 30 16:48:49 CST 2019
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}