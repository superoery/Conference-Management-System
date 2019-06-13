package team.softwarede.confersys.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author wyfca
 * 作用：会议室预约系统-浏览会议室列表-请求可用会议室
 */
public class MeetingRoomShowAvailForPage {
	
	private String mtDate;

    private String beginTime;
    
    private String endTime;
    
    private List<Integer> equipmentTypeIdList;
    
    private String capacity;
    
    public String getMtDate() {
		return mtDate;
	}
	public void setMtDate(String mtDate) {
		this.mtDate = mtDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<Integer> getEquipmentTypeIdList() {
		return equipmentTypeIdList;
	}
	public void setEquipmentTypeIdList(List<Integer> equipmentTypeIdList) {
		this.equipmentTypeIdList = equipmentTypeIdList;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
    
}
