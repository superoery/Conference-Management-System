package team.softwarede.confersys.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author wyfca
 * 作用：会议室预约系统-浏览会议室列表-请求可用会议室
 */
public class MeetingRoomShowAvailForPage {

    private Date beginTime;
    
    private Date endTime;
    
    private List<Integer> equipmentTypeIdList;
    
    private Integer capacity;
    
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
    public List<Integer> getEquipmentTypeIdList() {
		return equipmentTypeIdList;
	}
	public void setEquipmentTypeIdList(List<Integer> equipmentTypeIdList) {
		this.equipmentTypeIdList = equipmentTypeIdList;
	}
	public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    
}
