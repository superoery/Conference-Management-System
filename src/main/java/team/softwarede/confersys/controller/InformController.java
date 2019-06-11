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
import team.softwarede.confersys.biz.NotificationBiz;
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
//	@Autowired
//	NotificationBiz notificationBiz;

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
		
		
		List<NotificationMainPage> notificationList = new ArrayList<NotificationMainPage>();
		
		NotificationMainPage n = new NotificationMainPage();
		n.setNotificationId(17);
		n.setNotificationType("新会议");
		n.setReferMsg("srtp开会");
		
		NotificationMainPage m = new NotificationMainPage();
		m.setNotificationId(2);
		m.setNotificationType("报修");
		m.setReferMsg("逸夫楼601");
		
		notificationList.add(n);
		notificationList.add(m);
		
		map.addAttribute("notiList",notificationList);
		
		return "inform_list_show";
	}
	
	/**
	 * 显示待处理的特殊通知列表
	 */
	
	@RequestMapping("/sp/list.do")
	public String showSpInformList(ModelMap map) {
		
		List<NotificationSpIntro> notiSpIntroList = new ArrayList<NotificationSpIntro>();
		List<EnumNotificationSpType> eNotiSpTypeList = new ArrayList<EnumNotificationSpType>();
		
		for(EnumNotificationSpType e : EnumNotificationSpType.values()) {
			eNotiSpTypeList.add(e);
			
		}
		
		NotificationSpIntro spIntro1 = new NotificationSpIntro();
		spIntro1.setApplicantName("王教师");
		spIntro1.setUserId("10000001");
		spIntro1.setReferId(2);
		spIntro1.setNotificationSpType(EnumNotificationSpType.BOOK.getDescription());
		spIntro1.setApplyTime(new Date());
		
		NotificationSpIntro spIntro2 = new NotificationSpIntro();
		spIntro2.setApplicantName("云雀");
		spIntro2.setUserId("10000005");
		spIntro2.setReferId(14);
		spIntro2.setNotificationSpType(EnumNotificationSpType.LEAVE.getDescription());
		spIntro2.setApplyTime(new Date());
		
		NotificationSpIntro spIntro3 = new NotificationSpIntro();
		spIntro3.setApplicantName("大脸妹");
		spIntro3.setUserId("10000004");
		spIntro3.setReferId(1);
		spIntro3.setNotificationSpType(EnumNotificationSpType.REPAIR.getDescription());
		spIntro3.setApplyTime(new Date());
		
		notiSpIntroList.add(spIntro1);
		notiSpIntroList.add(spIntro2);
		notiSpIntroList.add(spIntro3);

		
		
		map.addAttribute("types",eNotiSpTypeList);
		map.addAttribute("notiSpIntroList", notiSpIntroList);
		
		return "informsp_list_show";
		
	}
	
	/**
	 * 显示待处理的特殊通知详情
	 */
	@RequestMapping(value = "/sp/details.do" , params = {"referId","type","applicantId"})
	public String showSpInformDetails(ModelMap map,
									  @ModelAttribute("referId")Integer referId,
									  @ModelAttribute("type")String type,
									  @ModelAttribute("applicantId")String applicantId){
		if(type.equals(EnumNotificationSpType.BOOK.getDescription())) {
			//显示预约详情
			
			MeetingApplyDetails mtApplyDetails = new MeetingApplyDetails();
			
			mtApplyDetails.setApplyId(2);
			mtApplyDetails.setMtContent("srtp开会");
			mtApplyDetails.setMtTopic("讨论怎么实现人工智能");
			mtApplyDetails.setApplicantId("10000001");
			mtApplyDetails.setApplicantName("王教师");
			mtApplyDetails.setMtRoomLocation("逸夫楼604");
			mtApplyDetails.setMeetingId(14);
			
			map.addAttribute("mtApplyDetails",mtApplyDetails);
			
			return "meeting_book_details_audit";
			
		}else if(type.equals(EnumNotificationSpType.REPAIR.getDescription())) {
			//显示报修详情
			
			EquipmentRepairDetails eRepairDetails = new EquipmentRepairDetails();
			
			eRepairDetails.setRepairId(1);
			eRepairDetails.setEquipmentId(13);
			eRepairDetails.setEquipmentName("投影仪1");
			eRepairDetails.setEquipmentType("投影仪");
			eRepairDetails.setRepairDetail("坏了");
			eRepairDetails.setRepairType("维修");
			eRepairDetails.setApplyTime(new Date());
			eRepairDetails.setApplicantName("大脸妹");
			eRepairDetails.setLocation("逸夫楼604");
			
			map.addAttribute("details", eRepairDetails);
			
			return "equipment_repair_audit";
			
		}else if(type.equals(EnumNotificationSpType.LEAVE.getDescription())) {
			//显示请假详情
			
			LeaveApplyShowDetail leaveDetails = new LeaveApplyShowDetail();
			
			leaveDetails.setLeaveApplicationId("10000005");
			leaveDetails.setLeaveApplicantName("云雀");
			leaveDetails.setLeaveApplyReason("病假");
			leaveDetails.setLeaveApplyTime(new Date());
			leaveDetails.setMtId(14);
			leaveDetails.setMtTopic("srtp开会");
			
			map.addAttribute("details", leaveDetails);
			
			return "meeting_leave_audit";
			
		}else {
			
			return "forward:/universal/result/show.do";
		}
		
	}
	
	
	
	
}
