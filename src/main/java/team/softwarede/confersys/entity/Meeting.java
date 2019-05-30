package team.softwarede.confersys.entity;

public class Meeting {


    private Integer id;

    private Integer meetingId;

    private String topic;

    private Integer number;

    private String meetingStatusId;

    private String meetingContent;

    private String meetingConclusion;

    private String applyStatusId;

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.id
     *
     * @param id the value for meeting.id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.meeting_id
     *
     * @return the value of meeting.meeting_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public Integer getMeetingId() {
        return meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.meeting_id
     *
     * @param meetingId the value for meeting.meeting_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.topic
     *
     * @return the value of meeting.topic
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public String getTopic() {
        return topic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.topic
     *
     * @param topic the value for meeting.topic
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.number
     *
     * @return the value of meeting.number
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.number
     *
     * @param number the value for meeting.number
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.meeting_status_id
     *
     * @return the value of meeting.meeting_status_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public String getMeetingStatusId() {
        return meetingStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.meeting_status_id
     *
     * @param meetingStatusId the value for meeting.meeting_status_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setMeetingStatusId(String meetingStatusId) {
        this.meetingStatusId = meetingStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.meeting_content
     *
     * @return the value of meeting.meeting_content
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public String getMeetingContent() {
        return meetingContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.meeting_content
     *
     * @param meetingContent the value for meeting.meeting_content
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.meeting_conclusion
     *
     * @return the value of meeting.meeting_conclusion
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public String getMeetingConclusion() {
        return meetingConclusion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.meeting_conclusion
     *
     * @param meetingConclusion the value for meeting.meeting_conclusion
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setMeetingConclusion(String meetingConclusion) {
        this.meetingConclusion = meetingConclusion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting.apply_status_id
     *
     * @return the value of meeting.apply_status_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public String getApplyStatusId() {
        return applyStatusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting.apply_status_id
     *
     * @param applyStatusId the value for meeting.apply_status_id
     *
     * @mbg.generated Thu May 30 09:12:43 CST 2019
     */
    public void setApplyStatusId(String applyStatusId) {
        this.applyStatusId = applyStatusId;
    }
}