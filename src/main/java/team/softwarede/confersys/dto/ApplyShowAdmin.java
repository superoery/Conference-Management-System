package team.softwarede.confersys.dto;

import java.util.Date;

/**
 * 
 * @author wyfca
 * 作用：会议室预约系统-审核会议室申请-返回会议室申请列表
 */
public class ApplyShowAdmin {

	private Integer applyId;
	
	private Date applyTime;

	private Integer mtRoomId;
	
	private String mtRoomNum;
	
	private Integer mtRoomFloor;
	
	private String mtRoomBuilding;
	
	private Integer mtId;
	
	private String mtTopic;
	
	private Integer mtOrganizerId;
	
	private String mtOrganizerName;
	
	private String applyStatus;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getMtRoomId() {
		return mtRoomId;
	}

	public void setMtRoomId(Integer mtRoomId) {
		this.mtRoomId = mtRoomId;
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

	public Integer getMtOrganizerId() {
		return mtOrganizerId;
	}

	public void setMtOrganizerId(Integer mtOrganizerId) {
		this.mtOrganizerId = mtOrganizerId;
	}

	public String getMtOrganizerName() {
		return mtOrganizerName;
	}

	public void setMtOrganizerName(String mtOrganizerName) {
		this.mtOrganizerName = mtOrganizerName;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
}
