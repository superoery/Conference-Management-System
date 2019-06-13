package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.RepairExaminationBiz;
import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.entity.NoticesKey;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.entity.RepairEquipment;
import team.softwarede.confersys.entity.RepairsKey;
import team.softwarede.confersys.enums.EnumEquipmentStatus;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.enums.EnumRepairStatus;
import team.softwarede.confersys.mapper.EquipmentMapper;
import team.softwarede.confersys.mapper.EquipmentTypeMapper;
import team.softwarede.confersys.mapper.MeetingRoomMapper;
import team.softwarede.confersys.mapper.NoticesMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
import team.softwarede.confersys.mapper.RepairEquipmentMapper;
import team.softwarede.confersys.mapper.RepairsMapper;

@Service("repairExaminationBiz")
public class RepairExaminationBizImpl implements RepairExaminationBiz{
	@Autowired
	RepairEquipmentMapper repairEquipmentMapper;
	@Autowired
	MeetingRoomMapper meetingRoomMapper;
	@Autowired
	NotificationMapper notificationMapper;
	@Autowired
	NoticesMapper noticesMapper;
	@Autowired
	EquipmentMapper equipmentMapper;
	@Autowired
	RepairsMapper repairsMapper;
	@Autowired
	EquipmentTypeMapper equipmentTypeMapper;
	
	
	@Transactional
	@Override
	public String repairExamination(int repairEquipmentId) {
		String msg;
		Notification notification = new Notification();
		notification.setId(null);
		notification.setNotificationType(EnumNotificationType.REPAIR.getDescription());
		notification.setNotificationStatus(EnumNotificationStatus.UNREAD.getDescription());
		notification.setReferId(String.valueOf(repairEquipmentId));
		NoticesKey notices = new NoticesKey();
		RepairEquipment record = repairEquipmentMapper.selectByPrimaryKey(repairEquipmentId);
		record.setRepairStatus(EnumRepairStatus.TREATED.getDescription());
		repairEquipmentMapper.updateByPrimaryKey(record);
		
		RepairsKey repaire = repairsMapper.selectByReEquipmentId(repairEquipmentId);
			
		Equipment equipment = equipmentMapper.selectByPrimaryKey(repaire.getEquipmentId());
		equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());
		equipmentMapper.updateByPrimaryKey(equipment);
//		Integer equipmentId = repairsMapper.selectByRepairEquipmentId(repairEquipmentId);
//		Integer roomId = equipmentMapper.selectRoomId(equipmentId);
		
		MeetingRoom mtRoom = meetingRoomMapper.selectByPrimaryKey(equipment.getMeetingRoomId());
		
		String mtRoomLocation = mtRoom.getBuilding()+mtRoom.getFloor()+mtRoom.getRoomNumber();
		
		EquipmentType eType = equipmentTypeMapper.selectByPrimaryKey(equipment.getEquipmentTypeId());
			
		notification.setNotificationDetail("您关于"+  mtRoomLocation+"的" + 
											eType.getTypeName() +"，设备编号为"+
											equipment.getEquipmentId().toString() +
											"的报修已成功处理，感谢您的反馈");
		msg = "succeed!";
		notificationMapper.insert(notification);
		int id = notificationMapper.selectByNotification(notification);
		
		notices.setNotificationId(id);
		notices.setUserId(record.getUserId());
		noticesMapper.insert(notices);
		return msg;
	}
	
}
