package team.softwarede.confersys.entity;

public class LeaveApplicationKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leave_application.user_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leave_application.meeting_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    private Integer meetingId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leave_application.user_id
     *
     * @return the value of leave_application.user_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leave_application.user_id
     *
     * @param userId the value for leave_application.user_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leave_application.meeting_id
     *
     * @return the value of leave_application.meeting_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    public Integer getMeetingId() {
        return meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leave_application.meeting_id
     *
     * @param meetingId the value for leave_application.meeting_id
     *
     * @mbg.generated Sun Jun 02 00:45:14 CST 2019
     */
    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }
}