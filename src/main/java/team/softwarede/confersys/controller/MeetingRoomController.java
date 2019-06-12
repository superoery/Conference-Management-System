package team.softwarede.confersys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomShowAvail;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserLogin;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.vo.UserAndGroupList;

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
			@ModelAttribute("selectedUAndGList") UserAndGroupList selectedUAndGList,
			RedirectAttributes attributes, 
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		List<EquipmentType> equipmentTypeList = meetingRoomBiz.showMtRoomBookPage();
		map.addAttribute("equipmentTypeList",equipmentTypeList);
		
		map.addAttribute("selectedUAndGList", (UserAndGroupList)session.getAttribute("selectedUAndGList"));
		
		return "mtRoom_searchAvail";
	}
	
	@RequestMapping("/searchUAndUG.do")
	public String searchAvail(
			@ModelAttribute("mtRoomSearch") String mtRoomSearch,
			RedirectAttributes attributes, 
			HttpSession session) {
		
		List<UserAndGroup> ListuAndG = userGroupBiz.searchUAndUGByKeyword(mtRoomSearch, ((BasicSession) session.getAttribute("userSession")).getUserId());
		UserAndGroupList uAndGList = new UserAndGroupList();
		uAndGList.setuAndGList(ListuAndG);
		attributes.addFlashAttribute("uAndGList",uAndGList);
		
		return "redirect:/meetingRoom/book.do";
	}
	
	@RequestMapping(value = "/addUAndUG.do", params = { "uAndGId", "uAndGName", "uAndGType"})
	public String searchAvail(ModelMap map,
			@ModelAttribute("uAndGId") String uAndGId,
			@ModelAttribute("uAndGName") String uAndGName,
			@ModelAttribute("uAndGType") Integer uAndGType,
			RedirectAttributes attributes, 
			HttpSession session) {
		UserAndGroupList selectedUAndGList = (UserAndGroupList)session.getAttribute("selectedUAndGList");
		UserAndGroup uAndG = new UserAndGroup();
		uAndG.setId(uAndGId);
		uAndG.setName(uAndGName);
		uAndG.setType(uAndGType);
		List<UserAndGroup> newList = new ArrayList<UserAndGroup>();
		if (selectedUAndGList != null && selectedUAndGList.getuAndGList()!=null) {
			if (selectedUAndGList.getuAndGList().size() != 0) {
				for (UserAndGroup tempUAndG : selectedUAndGList.getuAndGList()) {
					newList.add(tempUAndG);
				}
			}
		}
		newList.add(uAndG);
		System.out.println("uAndG.Type="+uAndG.getType());	
		System.out.println("uAndG.Name="+uAndG.getName());
		UserAndGroupList newSelectedUAndGList = new UserAndGroupList();
		newSelectedUAndGList.setuAndGList(newList);
		
		session.setAttribute("selectedUAndGList", newSelectedUAndGList);
		
		return "redirect:/meetingRoom/book.do";
	}
	
	@RequestMapping("/tobook.do")
	public String tobook(ModelMap map,
			@ModelAttribute("mtRoomAvail") MeetingRoomShowAvail mtRoomAvail,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		UserAndGroupList selectedUAndGList = (UserAndGroupList)session.getAttribute("selectedUAndGList");
		
		List<MeetingRoomAvail> allMtRoomAvail = meetingRoomBiz.showAvailMtRoom
				(mtRoomAvail.getBeginTime(), mtRoomAvail.getEndTime(), mtRoomAvail.getEquipmentTypeIdList(), selectedUAndGList.getuAndGList().size());
		
		map.addAttribute("allMtRoomAvail", allMtRoomAvail);
		
		return "mtRoom_book";
	}
	
	
}
