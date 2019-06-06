package team.softwarede.confersys.dto;

import java.util.Date;

public class RepairApplyDetail {

	private Integer repairId;
	
	private Integer repairEquipmentId;
	
	private String applicantId;
	
	private Date repairTime;
	
	private String repairType;
	
	private String repairDetail;
	
	private String repairStatus;

	public Integer getRepairId() {
		return repairId;
	}

	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
	}

	public Integer getRepairEquipmentId() {
		return repairEquipmentId;
	}

	public void setRepairEquipmentId(Integer repairEquipmentId) {
		this.repairEquipmentId = repairEquipmentId;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public Date getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}

	public String getRepairType() {
		return repairType;
	}

	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}

	public String getRepairDetail() {
		return repairDetail;
	}

	public void setRepairDetail(String repairDetail) {
		this.repairDetail = repairDetail;
	}

	public String getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}
	
}
