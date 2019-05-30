package team.softwarede.confersys.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author wyfca
 * 作用：会议信息管理系统-管理员和普通用户的查看会议详情功能-返回组织的会议详情（有与会者名单）
 */
public class MeetingDetail {

	private Integer mtId;
	
	private String mtTopic;
	
	private Date beginTime;
	
	private Date endTime;
	
	private String mtRoomNum;
	
	private Integer mtRoomFloor;
	
	private String mtRoomBuilding;
	
	private String mtContent;
	
	private String mtConclusion;
	
	private String mtStatus;
	
	private List<ParticipantBasicInfo> participantsList;
	
	private Integer mtNum;
	
	private String myParticipantStatus;

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

	public String getMtRoomNum() {
		return mtRoomNum;
	}

	public void setMtRoomNum(String mtRoomNum) {
		this.mtRoomNum = mtRoomNum;
	}

	public Integer getMtRoomFloor() {
		return mtRoomFloor;
	}

	public void setMtRoomFloor(Integer mtRoomFloor) {
		this.mtRoomFloor = mtRoomFloor;
	}

	public String getMtRoomBuilding() {
		return mtRoomBuilding;
	}

	public void setMtRoomBuilding(String mtRoomBuilding) {
		this.mtRoomBuilding = mtRoomBuilding;
	}

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}

	public String getMtConclusion() {
		return mtConclusion;
	}

	public void setMtConclusion(String mtConclusion) {
		this.mtConclusion = mtConclusion;
	}

	public String getMtStatus() {
		return mtStatus;
	}

	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	public List<ParticipantBasicInfo> getParticipantsList() {
		return participantsList;
	}

	public void setParticipantsList(List<ParticipantBasicInfo> participantsList) {
		this.participantsList = participantsList;
	}

	public Integer getMtNum() {
		return mtNum;
	}

	public void setMtNum(Integer mtNum) {
		this.mtNum = mtNum;
	}

	public String getMyParticipantStatus() {
		return myParticipantStatus;
	}

	public void setMyParticipantStatus(String myParticipantStatus) {
		this.myParticipantStatus = myParticipantStatus;
	}

}
