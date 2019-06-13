package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.EquipmentDetail;
import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.entity.Equipment;
/**
 * 
 * @author SunRonglin
 *
 */
public interface RepairApplicationBiz {
	
	String repairApplication(String userId, RepairApply repairApply);
	
	List<String> showAllRepairType();
	
	/**
	 * 根据设备编号显示设备详情
	 * @param equipmentId
	 * @return
	 */
	EquipmentDetail showEquipmentDetail(Integer equipmentId);
	
	/**
	 * 根据维修编号显示设备详情
	 * @param repairId
	 * @return
	 */
	EquipmentDetail showEquipmentDetailByRepairId(Integer repairId);
	
	List<Equipment> selectByMeetingRoomId(Integer meetingRoomId);
}
