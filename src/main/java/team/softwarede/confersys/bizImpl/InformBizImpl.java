/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.dto.NotificationMainPage;
import team.softwarede.confersys.dto.NotificationSpIntro;
import team.softwarede.confersys.entity.Apply;
import team.softwarede.confersys.entity.LeaveApplication;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.NoticesKey;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.entity.RepairEquipment;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumMeetingStatusId;
import team.softwarede.confersys.enums.EnumNotificationSpType;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.LeaveApplicationMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.NoticesMapper;
import team.softwarede.confersys.mapper.NotificationMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
import team.softwarede.confersys.mapper.RepairEquipmentMapper;
import team.softwarede.confersys.mapper.ScheduleMapper;
import team.softwarede.confersys.mapper.UserMapper;


/**
 * @author Mity1299
 *
 */
@Service("informBiz")
public class InformBizImpl implements InformBiz {

    @Autowired
    ApplyMapper applyMapper; 
    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    ScheduleMapper scheduleMapper; 
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    NoticesMapper noticesMapper;
    @Autowired
    ParticipatesMapper participatesMapper; 
    @Autowired
    UserMapper userMapper;
    @Autowired
    LeaveApplicationMapper leaveApplicationMapper;
    @Autowired
    RepairEquipmentMapper repairEquipmentMapper;
    
    @Transactional
    @Override
    public boolean auditMeeingBookApply(Integer mtRoomApplyId, Integer bookStatus) {
        // TODO Auto-generated method stub
        
        Apply apply = applyMapper.selectByPrimaryKey(mtRoomApplyId);
        
        
        Integer meetingId = apply.getMeetingId();
        Meeting meeting = meetingMapper.selectByPrimaryKey(meetingId);
        String meetingTopic = meeting.getTopic();
        Schedule schedule = scheduleMapper.selectByMtId(meetingId);
        String auditdetail = null;
        
        if(bookStatus==0) {
            //如果会议拒绝
            applyMapper.updateStatusById(mtRoomApplyId, EnumApplyStatusId.FAILED.getDescription());
            
            meetingMapper.updateStatusById(meetingId, EnumMeetingStatusId.FAILED.getDescription());
            auditdetail = "主题为\""+meetingTopic+"\"的会议预约未通过";
            
            
        }else if(bookStatus==1) {
            //如果会议通过
            applyMapper.updateStatusById(mtRoomApplyId, EnumApplyStatusId.SUCCEED.getDescription());
            
            meetingMapper.updateStatusById(meetingId, EnumMeetingStatusId.READY.getDescription());
            auditdetail = "主题为\""+ meetingTopic +"\"的会议预约已通过";
            Date beginDateTime = schedule.getBeginTime();
            Date endtDateTime = schedule.getEndTime();

            SimpleDateFormat sdfDate = new SimpleDateFormat("MM月dd日");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH时mm分");
            
            String date = sdfDate.format(beginDateTime);
            String beginTime = sdfTime.format(beginDateTime);
            String endTime = sdfTime.format(endtDateTime);
            
            String attendMtDetail = date + ",从" + beginTime + "到" + endTime 
                                    + "您需要参加 \"" + meetingTopic +"\"会议，请您做好与会准备"; 
            
            List<String> partUserIdList =participatesMapper.selectByMtId(meetingId);
            
            for(String userId : partUserIdList) {
                
                //插入与会通知
                Notification attendNoti = new Notification();
                attendNoti.setNotificationType(EnumNotificationType.MEETING.getDescription());
                attendNoti.setNotificationDetail(attendMtDetail);
                attendNoti.setNotificationStatus(EnumNotificationStatus.UNREAD.getDescription());
                attendNoti.setReferId(meetingId.toString());
                
                notificationMapper.insertSelective(attendNoti);
                
                //插入接收者和通知的联系
                NoticesKey noticesKey = new NoticesKey();
                noticesKey.setUserId(userId);
                noticesKey.setNotificationId(attendNoti.getId());
                
                noticesMapper.insert(noticesKey);
            }
            
        }else {
            return false;
        }
        
        //插入审核结果通知
        Notification auditNoti = new Notification();
        auditNoti.setNotificationType(EnumNotificationType.AUIDIT.getDescription());
        auditNoti.setNotificationDetail(auditdetail);
        auditNoti.setNotificationStatus(EnumNotificationStatus.UNREAD.getDescription());
        auditNoti.setReferId(meetingId.toString());
        
        notificationMapper.insertSelective(auditNoti);
        
        //插入接收者和通知的联系
        NoticesKey noticesKey = new NoticesKey();
        noticesKey.setUserId(apply.getUserId());
        noticesKey.setNotificationId(auditNoti.getId());
        
        noticesMapper.insert(noticesKey);
        
        return true;
    }
    
    @Transactional
    @Override
    public NotificationDetail showNormalInformDetail(Integer informId) {
        // TODO Auto-generated method stub
        NotificationDetail detail = new NotificationDetail();
        Notification notification = notificationMapper.selectByPrimaryKey(informId);
        
        String name = null;//referName
        
        String type =notification.getNotificationType();
        Integer referId = Integer.valueOf(notification.getReferId());
        
        detail.setNoteId(informId);
        detail.setNoteType(type);
        detail.setNoteDetail(notification.getNotificationDetail());
        detail.setNoteStatus(notification.getNotificationStatus());
        detail.setNoteReferMtId(referId);
        
        Meeting meeting = new Meeting();
        
        
        switch (EnumNotificationType.valueOfDescription(type)) {
        case REPAIR:{
                name =null;
        }break;
        case LEAVE:{
           
            meeting = meetingMapper.selectByPrimaryKey(referId);
            name = meeting.getTopic();                
        }break;
        case AUIDIT:{
            meeting = meetingMapper.selectByPrimaryKey(referId);
            name = meeting.getTopic();                
        }break;
        case MEETING:{
            meeting = meetingMapper.selectByPrimaryKey(referId);
            name = meeting.getTopic();
        }break;
        default:{
        
        }
        break;
        }

        detail.setNoteReferMtName(name);
        
       
        alterInformHaveRead(informId);
        
        return detail;
    }

    @Override
    public boolean alterInformHaveRead(Integer informId) {
        // TODO Auto-generated method stub
        String status = EnumNotificationStatus.READ.getDescription();
        notificationMapper.updateStatusByPrimaryKey(informId,status);
        return true;
    
    }
    //显示一般通知
    @Override
    public List<NotificationMainPage> ordinaryNotification(String userId, int roleId){
    	Notification dataItem = new Notification();
    	List<Notification> list= notificationMapper.selectNotification(userId);
    	List<NotificationMainPage> showList = new ArrayList();
    	for(int i = 0; i < list.size(); i++) {
    		dataItem = list.get(i);
    		NotificationMainPage showDataItem = new NotificationMainPage();
    		showDataItem.setNotificationId(dataItem.getId());
    		showDataItem.setNotificationType(dataItem.getNotificationType());
    		showDataItem.setReferMsg(dataItem.getReferId());
    		showList.add(showDataItem);
    		
    	}

    	return showList;
    }

    //显示特殊通知
    @Override
    public List<NotificationSpIntro> spNotificastion(int typeNum, int roleId){
    	if(roleId == 2) {
    		if(typeNum == EnumNotificationSpType.BOOK.ordinal()) {
        		List<Apply> applyList = applyMapper.selectAllApply();
        		List<NotificationSpIntro> spInfoList = new ArrayList();
        		Apply applyInfo = new Apply();
        		for(int i = 0; i < applyList.size(); i++) {
        			applyInfo = applyList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(applyInfo.getUserId());
        			spInfo.setReferId(applyInfo.getId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.BOOK.getDescription());
        			spInfo.setApplyTime(applyInfo.getApplyTime());
        			String userName = userMapper.selectNameByUserId(applyInfo.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		return spInfoList;
        		
        	}else if(typeNum == EnumNotificationSpType.LEAVE.ordinal()) {
        		List<LeaveApplication> leaveApplicationList = leaveApplicationMapper.selectAll();
        		List<NotificationSpIntro> spInfoList = new ArrayList();
        		LeaveApplication leaApp = new LeaveApplication();
        		for(int i = 0; i < leaveApplicationList.size(); i++) {
        			leaApp = leaveApplicationList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(leaApp.getUserId());
        			spInfo.setReferId(leaApp.getMeetingId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.LEAVE.getDescription());
        			spInfo.setApplyTime(leaApp.getApplyTime());
        			String userName = userMapper.selectNameByUserId(leaApp.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		return spInfoList;
        		
        	}else if(typeNum == EnumNotificationSpType.REPAIR.ordinal()){
        		List<RepairEquipment> repairEquipmentList = repairEquipmentMapper.selectAll();
        		List<NotificationSpIntro> spInfoList = new ArrayList();
        		RepairEquipment repairEquipment = new RepairEquipment();
        		for(int i = 0; i < repairEquipmentList.size(); i++) {
        			repairEquipment = repairEquipmentList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(repairEquipment.getUserId());
        			spInfo.setReferId(repairEquipment.getId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.REPAIR.getDescription());
        			spInfo.setApplyTime(repairEquipment.getRepairTime());
        			String userName = userMapper.selectNameByUserId(repairEquipment.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		return spInfoList;
        	}else {
        		List<Apply> applyList = applyMapper.selectAllApply();
        		List<NotificationSpIntro> spInfoList = new ArrayList();
        		Apply applyInfo = new Apply();
        		for(int i = 0; i < applyList.size(); i++) {
        			applyInfo = applyList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(applyInfo.getUserId());
        			spInfo.setReferId(applyInfo.getId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.BOOK.getDescription());
        			spInfo.setApplyTime(applyInfo.getApplyTime());
        			String userName = userMapper.selectNameByUserId(applyInfo.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		List<LeaveApplication> leaveApplicationList = leaveApplicationMapper.selectAll();
        		LeaveApplication leaApp = new LeaveApplication();
        		for(int i = 0; i < leaveApplicationList.size(); i++) {
        			leaApp = leaveApplicationList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(leaApp.getUserId());
        			spInfo.setReferId(leaApp.getMeetingId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.LEAVE.getDescription());
        			spInfo.setApplyTime(leaApp.getApplyTime());
        			String userName = userMapper.selectNameByUserId(leaApp.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		List<RepairEquipment> repairEquipmentList = repairEquipmentMapper.selectAll();
        		RepairEquipment repairEquipment = new RepairEquipment();
        		for(int i = 0; i < repairEquipmentList.size(); i++) {
        			repairEquipment = repairEquipmentList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(repairEquipment.getUserId());
        			spInfo.setReferId(repairEquipment.getId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.REPAIR.getDescription());
        			spInfo.setApplyTime(repairEquipment.getRepairTime());
        			String userName = userMapper.selectNameByUserId(repairEquipment.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		return spInfoList;
        	}
    	}else {
        		List<LeaveApplication> leaveApplicationList = leaveApplicationMapper.selectAll();
        		List<NotificationSpIntro> spInfoList = new ArrayList();
        		LeaveApplication leaApp = new LeaveApplication();
        		for(int i = 0; i < leaveApplicationList.size(); i++) {
        			leaApp = leaveApplicationList.get(i);
        			NotificationSpIntro spInfo = new NotificationSpIntro();
        			spInfo.setUserId(leaApp.getUserId());
        			spInfo.setReferId(leaApp.getMeetingId());
        			spInfo.setNotificationSpType(EnumNotificationSpType.LEAVE.getDescription());
        			spInfo.setApplyTime(leaApp.getApplyTime());
        			String userName = userMapper.selectNameByUserId(leaApp.getUserId());
        			spInfo.setApplicantName(userName);
        			spInfoList.add(spInfo);
        		}
        		return spInfoList;
        	
    		}
    	
    }
}   
