package team.softwarede.confersys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universal")
public class UniversalController {

	
	@RequestMapping("/result/show.do")
	public String showResult() {
		
		return "result_show";
	}
	
}
