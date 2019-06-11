package team.softwarede.confersys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingRoomShowAvail;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserAndGroupList;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.enums.EnumIdentity;

@Controller
@RequestMapping("/meetingRoom")
public class MeetingRoomController {
	
	@Autowired
	MeetingRoomBiz meetingRoomBiz;
	
	@Autowired
	UserGroupBiz userGroupBiz;

	@RequestMapping("/book.do")
	public String book(ModelMap map,
			@ModelAttribute("mtRoomAvail") MeetingRoomShowAvail mtRoomAvail,
			@ModelAttribute("uAndGList") UserAndGroupList uAndGList,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		List<EquipmentType> equipmentTypeList = meetingRoomBiz.showMtRoomBookPage();
		map.addAttribute("equipmentTypeList",equipmentTypeList);
		
		return "ugroup_mtroom_searchAvail";
	}
	
	@RequestMapping("/searchUAndUG.do")
	public String searchAvail(
			@ModelAttribute("mtRoomSearch") String mtRoomSearch,
			RedirectAttributes attributes, 
			HttpSession session) {
//		System.out.println("输入："+mtRoomSearch);
		List<UserAndGroup> ListuAndG = userGroupBiz.searchUAndUGByKeyword(mtRoomSearch, ((BasicSession) session.getAttribute("userSession")).getUserId());
		UserAndGroupList uAndGList = new UserAndGroupList();
		uAndGList.setuAndGList(ListuAndG);
		attributes.addFlashAttribute("uAndGList",uAndGList);
		return "redirect:/meetingRoom/book.do";
	}
	
//	@RequestMapping("/addUAndUG.do")
//	public String searchAvail(ModelMap map,
//			@ModelAttribute("uAndG") UserAndGroup uAndG,
//			RedirectAttributes attributes, 
//			HttpSession session) {
//		System.out.println("输入："+mtRoomSearch);
//		List<UserAndGroup> ListuAndG = userGroupBiz.searchUAndUGByKeyword(mtRoomSearch, ((BasicSession) session.getAttribute("userSession")).getUserId());
//		UserAndGroupList uAndGList = new UserAndGroupList();
//		uAndGList.setuAndGList(ListuAndG);
//		attributes.addFlashAttribute("uAndGList",uAndGList);
//		return "redirect:/meetingRoom/book.do";
//	}
//	@RequestMapping("/tobook.do")
	
	
}
