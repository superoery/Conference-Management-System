package team.softwarede.confersys.dto;

import java.util.Date;

public class EquipmentDetail {

	private Integer equipmentId;
	
	private String equipmentName;
	
	private Integer equipmentTypeName;
	
	private Integer meetingRoomId;
	
	private String roomNumber;
	
	private Integer floor;
	
	private String building;
	
	private Date storeTime;
	
	private String equipmentStatus;

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Integer getEquipmentTypeName() {
		return equipmentTypeName;
	}

	public void setEquipmentTypeName(Integer equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}

	public Integer getMeetingRoomId() {
		return meetingRoomId;
	}

	public void setMeetingRoomId(Integer meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Date getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}

	public String getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	
}
