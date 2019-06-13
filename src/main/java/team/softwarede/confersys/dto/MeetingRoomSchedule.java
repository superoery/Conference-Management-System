package team.softwarede.confersys.dto;

import java.util.Date;

public class MeetingRoomSchedule {

	private Integer mtId;
	
	private String mtTopic;
	
	private Date beginTime;
	
	private Date endTime;

	public Integer getMtId() {
		return mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public String getMtTopic() {
		return mtTopic;
	}

	public void setMtTopic(String mtTopic) {
		this.mtTopic = mtTopic;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
