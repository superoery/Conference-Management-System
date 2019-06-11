package team.softwarede.confersys.dto;

import team.softwarede.confersys.entity.RepairEquipment;

public class EquipmentRepairDetails {

	private RepairEquipment repairEquipment;
	
	private Integer equipmentId;
		
	private String mtRoomLocation;

	public RepairEquipment getRepairEquipment() {
		return repairEquipment;
	}

	public void setRepairEquipment(RepairEquipment repairEquipment) {
		this.repairEquipment = repairEquipment;
	}

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getMtRoomLocation() {
		return mtRoomLocation;
	}

	public void setMtRoomLocation(String mtRoomLocation) {
		this.mtRoomLocation = mtRoomLocation;
	}
	
	
	
	
	
}
