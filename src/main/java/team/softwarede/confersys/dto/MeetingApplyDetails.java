package team.softwarede.confersys.dto;

import team.softwarede.confersys.entity.Apply;
import team.softwarede.confersys.entity.Meeting;

public class MeetingApplyDetails {

	private Integer applyId;
	
	private String applicantId;
	
	private String applicantName;
	
	private String mtTopic;
	
	private String mtContent;
	
	private String mtRoomLocation;
	
	private Integer meetingId;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getMtTopic() {
		return mtTopic;
	}

	public void setMtTopic(String mtTopic) {
		this.mtTopic = mtTopic;
	}

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}

	public String getMtRoomLocation() {
		return mtRoomLocation;
	}

	public void setMtRoomLocation(String mtRoomLocation) {
		this.mtRoomLocation = mtRoomLocation;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	
}
