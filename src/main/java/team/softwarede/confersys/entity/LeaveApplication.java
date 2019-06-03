package team.softwarede.confersys.entity;

import java.util.Date;

public class LeaveApplication {

    private Integer meetingId;

    private String userId;

    private Date applyTime;

    private String applyStatusId;

    private String reason;

    public Integer getMeetingId() {
        return meetingId;
    }


    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Date getApplyTime() {
        return applyTime;
    }


    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyStatusId() {
        return applyStatusId;
    }

    public void setApplyStatusId(String applyStatusId) {
        this.applyStatusId = applyStatusId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}