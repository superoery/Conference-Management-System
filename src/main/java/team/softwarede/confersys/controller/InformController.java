package team.softwarede.confersys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.modeler.modules.ModelerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.biz.LeaveApplicationBiz;
import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.biz.RepairApplicationBiz;
import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.EquipmentRepairDetails;
import team.softwarede.confersys.dto.LeaveApplyShowDetail;
import team.softwarede.confersys.dto.MeetingApplyDetails;
import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.dto.NotificationMainPage;
import team.softwarede.confersys.dto.NotificationSpIntro;
import team.softwarede.confersys.entity.Apply;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.enums.EnumNotificationSpType;

@Controller
@RequestMapping("/inform")
public class InformController {

	@Autowired
	InformBiz informBiz;
	@Autowired
	LeaveApplicationBiz leaveApplicationBiz;
	@Autowired
	MeetingBiz meetingBiz;
	@Autowired
	MeetingRoomBiz meetingRoomBiz;
	@Autowired
	ShowMeetingMainPageBiz showMeetingMainPageBiz;
	
	
	@RequestMapping(value = "/normal/details.do",params = {"informId"},method = RequestMethod.GET)
	public String showNormalInformDetails(ModelMap map,
										  @ModelAttribute("informId")Integer informId) {
		
		NotificationDetail notiDetails = informBiz.showNormalInformDetail(informId);
		map.addAttribute("notiDetails", notiDetails);
		
		return "inform_details_show";
	}
	
//	@RequestMapping(value = "/normal/list",method = RequestMethod.GET)
//	public String showNormalInformList(HttpSession session,
//									   ModelMap map) {
//		
//		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
//		List<NotificationMainPage> notificationList = 
//		notificationBiz.notificationNewMeeting(userSession.getUserId(), userSession.getRole().getId());
//		
//		map.addAttribute("notiList",notificationList);
//		
//		return "inform_list_show";
//	}
	
	/**
	 * 显示一般通知列表
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/normal/list.do",method = RequestMethod.GET)
	public String showNormalInformList(HttpSession session,
									   ModelMap map) {
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		List<NotificationMainPage> notificationList = 
				informBiz.ordinaryNotification(userSession.getUserId(), userSession.getRole().getId());
				
		map.addAttribute("notiList",notificationList);
		
		return "inform_list_show";
	}
	
	/**
	 * 显示待处理的特殊通知列表
	 */
	@RequestMapping("/sp/list.do")
	public String showSpInformList(ModelMap map,
								   HttpSession session,
								   @ModelAttribute("selectedTypeId")Integer selectedTypeId) {
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		if(selectedTypeId==null) {
			selectedTypeId = EnumNotificationSpType.ALL.ordinal();
		}
		
		List<NotificationSpIntro> notiSpIntroList = informBiz.spNotificastion(selectedTypeId);
		List<EnumNotificationSpType> eNotiSpTypeList = new ArrayList<EnumNotificationSpType>();
		
		for(EnumNotificationSpType e : EnumNotificationSpType.values()) {
			eNotiSpTypeList.add(e);
			
		}
		
		
		map.addAttribute("selectedTypeId", selectedTypeId);
		map.addAttribute("types",eNotiSpTypeList);
		map.addAttribute("notiSpIntroList", notiSpIntroList);
		
		return "informsp_list_show";
		
	}
	
	/**
	 * 显示待处理的特殊通知详情
	 */
	@RequestMapping(value = "/sp/details.do" , params = {"referId","type","applicantId"})
	public String showSpInformDetails(ModelMap map,
									  HttpSession session,
									  @ModelAttribute("referId")Integer referId,
									  @ModelAttribute("type")String type,
									  @ModelAttribute("applicantId")String applicantId){
		
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		
		map.addAttribute("userSession", userSession);
		
		if(type.equals(EnumNotificationSpType.BOOK.getDescription())) {
			//显示预约详情
			
			MeetingApplyDetails mtApplyDetails =  meetingBiz.showMtRoomBookDetails(referId);
			
			map.addAttribute("mtApplyDetails",mtApplyDetails);
			
			return "meeting_book_details_audit";
			
		}else if(type.equals(EnumNotificationSpType.REPAIR.getDescription())) {
			//显示报修详情
			
			EquipmentRepairDetails eRepairDetails = meetingRoomBiz.repairDetails(referId); 
			
			map.addAttribute("details", eRepairDetails);
			
			return "equipment_repair_audit";
			
		}else if(type.equals(EnumNotificationSpType.LEAVE.getDescription())) {
			
			//显示请假详情
			LeaveApplyShowDetail leaveDetails = leaveApplicationBiz.showLeaveApplylDetails(applicantId, referId); 
			
			map.addAttribute("details", leaveDetails);
						
			return "meeting_leave_audit";
			
		}else {
			
			return "forward:/universal/result/show.do";
		}
		
	}
	
	
	
	
}
