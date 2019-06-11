package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.RepairExaminationBiz;
import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.entity.NoticesKey;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.entity.RepairEquipment;
import team.softwarede.confersys.enums.EnumEquipmentStatus;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.enums.EnumRepairStatus;
import team.softwarede.confersys.mapper.EquipmentMapper;
import team.softwarede.confersys.mapper.NoticesMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
import team.softwarede.confersys.mapper.RepairEquipmentMapper;

@Service("repairExaminationBiz")
public class RepairExaminationBizImpl implements RepairExaminationBiz{
	@Autowired
	RepairEquipmentMapper repairEquipmentMapper;
	
	@Autowired
	NotificationMapper notificationMapper;
	
	@Autowired
	NoticesMapper noticesMapper;
	
	@Autowired
	EquipmentMapper equipmentMapper;
	
	@Transactional
	@Override
	public String repairExamination(int repairEquipmentId, RepairApply repairApply) {
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
			
		Equipment equipment = equipmentMapper.selectByPrimaryKey(repairApply.getRepairEquipmentId());
		equipment.setEquipmentStatus(EnumEquipmentStatus.AVAILABLE.getDescription());
		equipmentMapper.updateByPrimaryKey(equipment);
			
		notification.setNotificationDetail("succeed!");
			
		msg = "succeed!";
		notificationMapper.insert(notification);
		int id = notificationMapper.selectByNotification(notification);
		
		notices.setNotificationId(id);
		notices.setUserId(record.getUserId());
		noticesMapper.insert(notices);
		return msg;
	}
	
}
