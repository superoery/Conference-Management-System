package team.softwarede.confersys.bizImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.RepairApplicationBiz;
import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.entity.RepairEquipment;
import team.softwarede.confersys.entity.RepairsKey;
import team.softwarede.confersys.enums.EnumEquipmentStatus;
import team.softwarede.confersys.enums.EnumRepairStatus;
import team.softwarede.confersys.enums.EnumRepairType;
import team.softwarede.confersys.mapper.EquipmentMapper;
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
	RepairsMapper repairsMapper;
	
	@Autowired
	EquipmentMapper equipmentMapper;
	
	@Transactional
	@Override
	public String repairApplication(String userId, RepairApply repairApply) {
		RepairEquipment record = new RepairEquipment();
		Date repairTime = new Date();
		record.setRepairType(repairApply.getRepairType());
		record.setRepairDetail(repairApply.getRepairDetail());
		record.setRepairTime(repairTime);
		record.setRepairStatus(EnumRepairStatus.UNTREATED.getDescription());
		record.setId(null);
		record.setUserId(userId);
		repairEquipmentMapper.insert(record);
		
		RepairsKey repairs = new RepairsKey();
		repairs.setEquipmentId(repairApply.getRepairEquipmentId());
		repairs.setRepairEquipmentId(record.getId());
		repairsMapper.insert(repairs);
		
		Equipment equipment = equipmentMapper.selectByPrimaryKey(repairApply.getRepairEquipmentId());
		if(repairApply.getRepairType().equals(EnumRepairType.REPAIRMENT.getDescription())) {
			equipment.setEquipmentStatus(EnumEquipmentStatus.REPAIRING.getDescription());
		} else {
			equipment.setEquipmentStatus(EnumEquipmentStatus.LACK.getDescription());
		}
		equipmentMapper.updateByPrimaryKey(equipment);
		String msg = "succeed!";
		return msg;
		
	}
}
