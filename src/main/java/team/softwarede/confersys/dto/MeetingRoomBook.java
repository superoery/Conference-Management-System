package team.softwarede.confersys.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author wyfca
 * 作用：会议室预约系统-预约会议室-请求提交会议室预约
 */
public class MeetingRoomBook {
	
	private String mtTopic;
	
	private Date beginTime;
	
	private Date endTime;
	
	private String mtContent;
	
	private List<Integer> mtParticipantsIdList;
	
	private Integer mtRoomId;
	
	private Integer mtOrganizerId;

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

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}

	public List<Integer> getMtParticipantsIdList() {
		return mtParticipantsIdList;
	}

	public void setMtParticipantsIdList(List<Integer> mtParticipantsIdList) {
		this.mtParticipantsIdList = mtParticipantsIdList;
	}

	public Integer getMtRoomId() {
		return mtRoomId;
	}

	public void setMtRoomId(Integer mtRoomId) {
		this.mtRoomId = mtRoomId;
	}

	public Integer getMtOrganizerId() {
		return mtOrganizerId;
	}

	public void setMtOrganizerId(Integer mtOrganizerId) {
		this.mtOrganizerId = mtOrganizerId;
	}
}
