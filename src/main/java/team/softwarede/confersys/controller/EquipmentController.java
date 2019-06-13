package team.softwarede.confersys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import team.softwarede.confersys.biz.RepairApplicationBiz;
import team.softwarede.confersys.biz.RepairExaminationBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.RepairApply;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	@Autowired
	RepairApplicationBiz repairApplicationBiz;
	@Autowired
	RepairExaminationBiz repairExaminationBiz;

	@RequestMapping("/repair.do")
	public String repairApply(ModelMap map,
			@ModelAttribute("repairApply") RepairApply repairApply,
			HttpSession session) {
		List<String> repairTypeList = repairApplicationBiz.showAllRepairType();
		map.addAttribute("repairTypeList", repairTypeList);

//		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
//		map.addAttribute("userSession",userSession);
		return "equipment_repair";
	}
	
	@RequestMapping("/repair_submit.do")
	public String repairApplySubmit(ModelMap map,
			HttpSession session,
			@ModelAttribute("repairApply") RepairApply repairApply) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		repairApply.setDate(new Date());
		repairApplicationBiz.repairApplication(userSession.getUserId(), repairApply);
		map.addAttribute("userSession",userSession);
		return "equipment_repair_submitMsg";
	}
	
	@RequestMapping(value = "/repair/audit.do" , params = {"repairEquipmentId"})
	public String repairAudit(ModelMap map,
							  @ModelAttribute("repairEquipmentId")Integer repairEquipmentId) {
		String title = "审核报修申请";
		String msg = null;
		String result = repairExaminationBiz.repairExamination(repairEquipmentId);
		
		if("succeed!".equals(result)) {
			msg = "成功处理报修申请";
		}else {
			msg = "处理报修申请失败，请重新操作";
		}
		
		map.addAttribute("title", title);
		map.addAttribute("msg", msg);
		
		return "forward:/universal/result/show.do";
	}
}
