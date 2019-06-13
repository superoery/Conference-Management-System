package team.softwarede.confersys.bizImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.RepairApplicationBiz;
import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.dto.UserSearch;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.entity.NoticesKey;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.entity.RepairEquipment;
import team.softwarede.confersys.entity.RepairsKey;
import team.softwarede.confersys.enums.EnumEquipmentStatus;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.enums.EnumRepairStatus;
import team.softwarede.confersys.enums.EnumRepairType;
import team.softwarede.confersys.mapper.EquipmentMapper;
import team.softwarede.confersys.mapper.NoticesMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
import team.softwarede.confersys.mapper.RepairEquipmentMapper;
import team.softwarede.confersys.mapper.RepairsMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("repairApplicationBiz")
public class RepairApplicationBizImpl implements RepairApplicationBiz{
	@Autowired
	RepairEquipmentMapper repairEquipmentMapper;
	@Autowired
	NotificationMapper notificationMapper;
	@Autowired
	RepairsMapper repairsMapper;
	@Autowired
	NoticesMapper noticesMapper;
	@Autowired
	EquipmentMapper equipmentMapper;
	
	@Transactional
	@Override
	public String repairApplication(String userId, RepairApply repairApply) {
		RepairEquipment record = new RepairEquipment();
		Date repairTime = new Date();
		Equipment equipment = equipmentMapper.selectByPrimaryKey(repairApply.getRepairEquipmentId());
		
		if(equipment!=null) {
			record.setRepairType(repairApply.getRepairType());
			record.setRepairDetail(repairApply.getRepairDetail());
			record.setRepairTime(repairTime);
			record.setRepairStatus(EnumRepairStatus.UNTREATED.getDescription());
			record.setId(null);
			record.setUserId(userId);
			repairEquipmentMapper.insertSelective(record);
					
			RepairsKey repairs = new RepairsKey();
			repairs.setEquipmentId(repairApply.getRepairEquipmentId());
			repairs.setRepairEquipmentId(record.getId());
			repairsMapper.insert(repairs);

			if(repairApply.getRepairType().equals(EnumRepairType.REPAIRMENT.getDescription())) {
				equipment.setEquipmentStatus(EnumEquipmentStatus.REPAIRING.getDescription());
			} else {
				equipment.setEquipmentStatus(EnumEquipmentStatus.LACK.getDescription());
			}
			equipmentMapper.updateByPrimaryKey(equipment);
			
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
			String date = sdf.format(repairApply.getDate());
			
			Notification notification = new Notification();
			notification.setNotificationStatus(EnumNotificationStatus.UNREAD.getDescription());
			notification.setNotificationType(EnumNotificationType.REPAIR.getDescription());
			notification.setReferId("0");
			notification.setNotificationDetail("对不起，由于您于"+date+"报修的设备编号不存在，报修无效");
			
			notificationMapper.insertSelective(notification);
			
			NoticesKey noticesKey = new NoticesKey();
			
			noticesKey.setNotificationId(notification.getId());
			noticesKey.setUserId(userId);
			
			noticesMapper.insert(noticesKey);
		}
		String msg = "succeed!";
		return msg;
		
	}

    @Override
    public List<String> showAllRepairType() {
        // TODO Auto-generated method stub
        
        List<String> repairTypeList = new ArrayList<String>();
        
        for (EnumRepairType eRepairType : EnumRepairType.values()) {
            
            repairTypeList.add(eRepairType.getDescription());
            
        }
        
        return repairTypeList;
    }
}
