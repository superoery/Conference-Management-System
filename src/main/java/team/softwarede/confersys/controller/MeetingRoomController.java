package team.softwarede.confersys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.biz.ShowMtRoomInfoBiz;
import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.dto.MeetingRoomSchedule;
import team.softwarede.confersys.dto.MeetingRoomScheduleOrg;
import team.softwarede.confersys.dto.MeetingRoomShowAvailForPage;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.enums.EnumRoleName;
import team.softwarede.confersys.vo.UserAndGroupList;

@Controller
@RequestMapping("/meetingRoom")
public class MeetingRoomController {
	
	@Autowired
	MeetingRoomBiz meetingRoomBiz;
	
	@Autowired
	UserGroupBiz userGroupBiz;
	
	@Autowired
	MeetingBiz meetingBiz;
	
	@Autowired
	ShowMtRoomInfoBiz showMtRoomInfoBiz;

	@RequestMapping("/showList.do")
	public String showMtRoomList(ModelMap map) {
		List<MeetingRoomAvail> mtRoomList = meetingRoomBiz.showAllMtRoom();
		map.addAttribute("mtRoomList", mtRoomList);
		
		return "mtRoom";
	}
	
	@RequestMapping(value = "/show_detail.do", params = {"mtRoomId"})
	public String showMtRoomDetail(ModelMap map,
			@ModelAttribute("mtRoomId") Integer mtRoomId,
			HttpSession session) {
		MeetingRoom mtRoom = showMtRoomInfoBiz.showMtRoomInfo(mtRoomId);
		map.addAttribute("mtRoom", mtRoom);
		
		BasicSession userSession = (BasicSession)session.getAttribute("userSession");
		
		if(userSession.getRole().getRole()==EnumRoleName.ADMIN.getDescription()) {
			List<MeetingRoomSchedule> scheduleList = meetingRoomBiz.showMtRoomSchedule(mtRoomId);
			map.addAttribute("scheduleList", scheduleList);
		}else if(userSession.getRole().getRole()==EnumRoleName.ORGANIZER.getDescription()) {
			List<MeetingRoomScheduleOrg> scheduleList = meetingRoomBiz.showMtRoomScheduleOrg(mtRoomId);
			map.addAttribute("scheduleList", scheduleList);
		}
		
		return "mtRoom_detail";
	}
	
	@RequestMapping("/book.do")
	public String book(ModelMap map,
			@ModelAttribute("mtRoomAvail") MeetingRoomShowAvailForPage mtRoomAvail,
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
		UserAndGroupList newSelectedUAndGList = new UserAndGroupList();
		newSelectedUAndGList.setuAndGList(newList);
		
		session.setAttribute("selectedUAndGList", newSelectedUAndGList);
		
		return "redirect:/meetingRoom/book.do";
	}
	
	
	@RequestMapping("/searchAvail.do")
	public String tobook(ModelMap map,
			@Valid @ModelAttribute("mtRoomBook") MeetingRoomBook mtRoomBook,
			BindingResult bindResult1,
			@Valid @ModelAttribute("mtRoomAvail") MeetingRoomShowAvailForPage mtRoomAvail,
			BindingResult bindResult2,
			HttpSession session) throws ParseException {
//		if(bindResult2.hasErrors()) {
//			return "redirect:/meetingRoom/book.do";
//		}
		for(int i=0; i<mtRoomAvail.getEquipmentTypeIdList().size(); i++)
			System.out.println("equipmentTypeIdList: " + mtRoomAvail.getEquipmentTypeIdList().get(i));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		String beginTS = mtRoomAvail.getMtDate()+"-"+mtRoomAvail.getBeginTime();
		Date beginT = formatter.parse(beginTS);
		String endTS = mtRoomAvail.getMtDate()+"-"+mtRoomAvail.getEndTime();
		Date endT = formatter.parse(endTS);
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession",userSession);
		
		UserAndGroupList selectedUAndGList = (UserAndGroupList)session.getAttribute("selectedUAndGList");
		
		List<MeetingRoomAvail> allMtRoomAvail = meetingRoomBiz.showAvailMtRoom
				(beginT, endT, mtRoomAvail.getEquipmentTypeIdList(), selectedUAndGList.getuAndGList().size());
		
		map.addAttribute("allMtRoomAvail", allMtRoomAvail);
		session.setAttribute("beginTime", beginTS);
		session.setAttribute("endTime", endTS);
		
		return "mtRoom_book";
	}
	
	
	@RequestMapping("/mt_create.do")
	public String mtCreate(ModelMap map,
			@Valid @ModelAttribute("mtRoomBook") MeetingRoomBook mtRoomBook,
			BindingResult bindResult,
			HttpSession session) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		String beginTS = (String)session.getAttribute("beginTime");
		Date beginT = formatter.parse(beginTS);
		String endTS = (String)session.getAttribute("endTime");
		Date endT = formatter.parse(endTS);

		mtRoomBook.setBeginTime(beginT);
		mtRoomBook.setEndTime(endT);
		
		UserAndGroupList selectedUAndGList = (UserAndGroupList)session.getAttribute("selectedUAndGList");
		List<UserAndGroup> sUAndGList = selectedUAndGList.getuAndGList();
		List<String> mtParticipantsIdList = new ArrayList<String>();
		List<Integer> uGroupIdList = new ArrayList<Integer>();
		
		for(int i=0; i<sUAndGList.size(); i++) {
			UserAndGroup temp = sUAndGList.get(i);
			if(temp.getType()==0) {
				// 用户
				mtParticipantsIdList.add(temp.getId());
			} else {
				// 用户组
				uGroupIdList.add(Integer.parseInt(temp.getId()));
			}
		}
		
		mtRoomBook.setMtOrganizerId(((BasicSession)session.getAttribute("userSession")).getUserId());
		mtRoomBook.setMtParticipantsIdList(mtParticipantsIdList);
		mtRoomBook.setuGroupIdList(uGroupIdList);
		
		if(meetingBiz.createMt(mtRoomBook)) {
			map.addAttribute("createMtMsg", "创建新会议、预约会议室成功！正在等待管理员审核，请注意接收审核通知。");
		}else {
			map.addAttribute("createMtMsg", "创建新会议、预约会议室失败！请稍后重试！");
		}
		session.removeAttribute("beginTime");
		session.removeAttribute("endTime");
		session.removeAttribute("selectedUAndGList");
		return "mtRoom_submitMsg";
		
	}
	
	
}
