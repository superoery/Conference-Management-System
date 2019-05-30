package team.softwarede.confersys.dto;

import java.util.Date;

/**
 * 
 * @author wyfca
 * 作用：登录系统-显示主界面-返回参与的/组织的/全部的会议列表
 */
public class MeetingMainPage {

	private Integer mtId;
	
	private String mtTopic;
	
	private Date beginTime;
	
	private Date endTime;
	
	private String mtRoomNum;
	
	private Integer mtRoomFloor;
	
	private String mtRoomBuilding;
	
	private String mtStatus;

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

	public String getMtStatus() {
		return mtStatus;
	}

	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}
}
