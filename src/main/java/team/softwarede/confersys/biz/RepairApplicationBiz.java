package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.RepairApply;
import team.softwarede.confersys.enums.EnumRepairType;
/**
 * 
 * @author SunRonglin
 *
 */
public interface RepairApplicationBiz {
	String repairApplication(String userId, RepairApply repairApply);
	
	List<String> showAllRepairType();
}
