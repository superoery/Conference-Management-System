/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.entity.Apply;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.Participates;
import team.softwarede.confersys.entity.ParticipatesMeetingKey;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumMeetingStatusId;
import team.softwarede.confersys.enums.EnumParticipatesStatus;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
import team.softwarede.confersys.mapper.ParticipatesMeetingMapper;
import team.softwarede.confersys.mapper.ScheduleMapper;

/**
 * @author Mity1299
 *
 */
@Service("meetingBiz")
public class MeetingBizImpl implements MeetingBiz {

    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    ParticipatesMapper participatesMapper;
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    ScheduleMapper scheduleMapper; 
    @Autowired
    ParticipatesMeetingMapper participatesMeetingMapper;
    
    
    @Transactional
    @Override
    public boolean createMt(MeetingRoomBook mtRoomBook) {
        // TODO Auto-generated method stub
        
        
        //计算与会人数
        List<String> mtParticipatesIdList = mtRoomBook.getMtParticipantsIdList();
        Integer capacity = mtParticipatesIdList.size();
        List<Integer> uGroupPartIdList = mtRoomBook.getuGroupIdList();
        
        //插入会议
        Meeting meeting = new Meeting();
        meeting.setTopic(mtRoomBook.getMtTopic());
        meeting.setMeetingContent(mtRoomBook.getMtContent());
        meeting.setNumber(capacity);
        meeting.setApplyStatusId(EnumApplyStatusId.EXAMING.getDescription());
        meeting.setMeetingStatusId(EnumMeetingStatusId.AUDITING.getDescription());
        
        meetingMapper.insertSelective(meeting);
        Integer meetingId = meeting.getId();
        
        
        //插入日程
        Schedule schedule = new Schedule();
        schedule.setMeetingId(meetingId);
        schedule.setMeetingRoomId(mtRoomBook.getMtRoomId());
        schedule.setBeginTime(mtRoomBook.getBeginTime());
        schedule.setEndTime(mtRoomBook.getEndTime());
        
        scheduleMapper.insert(schedule);
        
        /*
         * //插入用户组的与会联系//不用用户组的与会联系了 没啥用
         * 
         * //将用户组的用户编号加入用户列表 //用户列表去重 for(Integer uGroupId : uGroupPartIdList) {
         * ParticipatesMeetingKey partMtKey = new ParticipatesMeetingKey();
         * partMtKey.setMeetingId(meetingId); partMtKey.setUserGroupId(uGroupId);
         * participatesMeetingMapper.insertSelective(partMtKey); }
         */
        
        
        //将会议组织者加入与会列表
        mtParticipatesIdList.add(mtRoomBook.getMtOrganizerId());
        
        //添加用户和会议的关联
        for(String userId : mtParticipatesIdList) {
            
            Participates participates = new Participates();
            participates.setUserId(userId);
            participates.setMeetingId(meetingId);
            participates.setParticipantsStatus(EnumParticipatesStatus.ATTEND.getDescription());
            
            participatesMapper.insertSelective(participates);
        }
        

        //插入申请表
        Apply apply = new Apply();
        apply.setUserId(mtRoomBook.getMtOrganizerId());
        apply.setMeetingId(meetingId);
        apply.setApplyStatusId(EnumApplyStatusId.EXAMING.getDescription());
        apply.setApplyTime(new Date());
        
        applyMapper.insertSelective(apply);
        
        return true;
    }

}
