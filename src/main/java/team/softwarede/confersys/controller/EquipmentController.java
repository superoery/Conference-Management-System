package team.softwarede.confersys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.RepairApplicationBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.RepairApply;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired
	RepairApplicationBiz repairApplicationBiz;

	@RequestMapping("/repair.do")
	public String repairApply(ModelMap map,
			HttpSession session) {
//		RepairTypeList repairTypeList = repairApplicationBiz.showAllRepairType();
//		map.addAttribute("repairTypeList", repairTypeList);

		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		return "equipment_repair";
	}
	
	@RequestMapping("/repair_submit.do")
	public String repairApplySubmit(ModelMap map,
			HttpSession session,
			@ModelAttribute("repairApply") RepairApply repairApply) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		repairApplicationBiz.repairApplication(userSession.getUserId(), repairApply);
		map.addAttribute("userSession",userSession);
		return "equipment_repair_submitMsg";
	}
}
