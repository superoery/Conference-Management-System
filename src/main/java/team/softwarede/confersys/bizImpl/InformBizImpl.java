/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.NotificationMapper;

/**
 * @author Mity1299
 *
 */
@Service("informBiz")
public class InformBizImpl implements InformBiz {

    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    MeetingMapper meetingMapper;
    
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
        detail.setNoteStatus(notification.getNotificationnStatus());
        detail.setNoteReferMtId(referId);
        
        Meeting meeting = new Meeting();
        //除了报修通知，其他类型的通知在这里都填会议信息
        
        switch (EnumNotificationType.valueOfDescription(type)) {
        case REPAIR:{
                name =null;
        }break;
        case LEAVE:{
            //如果是请假通知，则找到请假对应的会议
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
        
        //将通知改为已读
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

}
