package team.softwarede.confersys.bizImpl;

import java.util.ArrayList;
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
import team.softwarede.confersys.entity.ParticipatesKey;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumMeetingStatusId;
import team.softwarede.confersys.enums.EnumParticipatesStatus;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.BelongsToMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
import team.softwarede.confersys.mapper.ScheduleMapper;
import team.softwarede.confersys.util.UtilConfer;

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
    BelongsToMapper belongsToMapper; 
    
    @Transactional
    @Override
    public boolean bookMtRoomAgain(String organizerId,Integer meetingId,MeetingRoomBook mtRoomBook) {
        // TODO Auto-generated method stub
        //除了会议组织者的编号不能改，其他都能改
        
        //计算与会人数
        List<String> mtParticipatesIdList = mtRoomBook.getMtParticipantsIdList();
        Integer capacity = mtParticipatesIdList.size();
        List<Integer> uGroupPartIdList = mtRoomBook.getuGroupIdList();
        
        //根据会议编号更新会议信息
        Meeting meeting = new Meeting();
        meeting.setId(meetingId);
        meeting.setTopic(mtRoomBook.getMtTopic());
        meeting.setMeetingContent(mtRoomBook.getMtContent());
        meeting.setNumber(capacity);
        meeting.setApplyStatusId(EnumApplyStatusId.EXAMING.getDescription());
        meeting.setMeetingStatusId(EnumMeetingStatusId.AUDITING.getDescription());
        
        meetingMapper.updateByPrimaryKeySelective(meeting);

        
        //更新日程
        Schedule schedule = new Schedule();
        schedule.setMeetingId(meetingId);
        schedule.setMeetingRoomId(mtRoomBook.getMtRoomId());
        schedule.setBeginTime(mtRoomBook.getBeginTime());
        schedule.setEndTime(mtRoomBook.getEndTime());
        
        scheduleMapper.updateByMtIdSelective(schedule);
        
        
        List<String> oldPartList = participatesMapper.selectByMtId(meetingId);
        List<String> newPartList = mtRoomBook.getMtParticipantsIdList();
        newPartList.add(organizerId);//添加会议组织者的编号
        
        //求需要删除的与会关系
        oldPartList.remove(newPartList);
        List<String> deletePartList = oldPartList;
        //求需要添加的与会关系
        newPartList.remove(oldPartList);
        List<String> insertPartList = newPartList;
        
        //删除多余的与会关系
        for(String s : deletePartList) {
            ParticipatesKey key = new ParticipatesKey();
            key.setUserId(s);
            key.setMeetingId(meetingId);
            participatesMapper.deleteByPrimaryKey(key);
        }
        
        //插入新增的与会关系
        for(String s : insertPartList) {
            Participates key = new Participates();
            key.setUserId(s);
            key.setMeetingId(meetingId);
            key.setParticipantsStatus(EnumParticipatesStatus.ATTEND.getDescription());
            participatesMapper.insert(key);
        }
        

        //修改申请
        Apply apply = new Apply();
        apply.setMeetingId(meetingId);
        apply.setApplyStatusId(EnumApplyStatusId.EXAMING.getDescription());
        apply.setApplyTime(new Date());
        
        applyMapper.updateByMtIdSelective(apply);

        return true;
    }

    
    
    @Transactional
    @Override
    public boolean createMt(MeetingRoomBook mtRoomBook) {
        // TODO Auto-generated method stub
        
        
        //计算与会人数
        List<String> mtParticipatesIdList = mtRoomBook.getMtParticipantsIdList();
        Integer capacity =0;
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
        

        //将用户组的用户编号加入用户列表 
        //用户列表去重 
        List<String> uIdListInGroupList = new ArrayList<String>();
        for(Integer uGroupId : uGroupPartIdList) {
            List<String> uIdListTmp = belongsToMapper.selectByUGroupId(uGroupId);
            uIdListInGroupList.addAll(uIdListTmp);
        }
        
        List<String> totalUIdList = new ArrayList<String>();
        totalUIdList.addAll(uIdListInGroupList);
        totalUIdList.addAll(mtParticipatesIdList);
        //将会议组织者加入与会列表
        totalUIdList.add(mtRoomBook.getMtOrganizerId());
        UtilConfer.removeDuplicate(totalUIdList);
        
        
        
        capacity = totalUIdList.size();
        
        //添加用户和会议的关联
        for(String userId : totalUIdList) {
            
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
