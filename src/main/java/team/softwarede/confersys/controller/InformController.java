package team.softwarede.confersys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.NotificationDetail;

@Controller
@RequestMapping("/inform")
public class InformController {

	@Autowired
	InformBiz informBiz;
	
	@RequestMapping(value = "/normal/details/{informId}",method = RequestMethod.GET)
	public String showNormalInformDetails(ModelMap map,
										  @PathVariable("informId")Integer informId) {
		
		NotificationDetail notiDetails = informBiz.showNormalInformDetail(informId);
		map.addAttribute("notiDetails", notiDetails);
		
		return "inform_details_show";
	}
	
	
	
}
