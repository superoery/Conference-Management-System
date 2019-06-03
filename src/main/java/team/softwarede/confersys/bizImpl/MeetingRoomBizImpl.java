/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
import team.softwarede.confersys.mapper.ScheduleMapper;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;


/**
 * @author Mity1299
 *
 */
@Service("meetingRoomBiz")
public class MeetingRoomBizImpl implements MeetingRoomBiz{

    @Autowired
    MeetingRoomAvailMapper meetingRoomBookMapper;
    @Autowired
    ParticipatesMapper participatesMapper;
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    ScheduleMapper scheduleMapper;
    
    
    /**
     * 显示可选会议室列表
     */

    @Override
    public List<MeetingRoomAvail> showAvailMtRoom(Date beginTime, 
                                                 Date endTime, 
                                                 List<Integer> equipmentTypeIdList,
                                                 Integer capacity) {
        // TODO Auto-generated method stub

        String applyStatusId = EnumApplyStatusId.SUCCEED.getDescription();

        List<MeetingRoomAvail> meetingRoomBookList =
                meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity,applyStatusId);

        
        return meetingRoomBookList;
    }

    @Transactional
    @Override
    public Boolean bookMtRoom(MeetingRoomBook meetingRoomBook) {
        // TODO Auto-generated method stub
        
        //根据会议名称、会议状态、会议内容、会议申请状态插入会议
        Meeting meeting = new Meeting();
        String mtTopic = meetingRoomBook.getMtTopic();
        String mtContent = meetingRoomBook.getMtContent();
        
        meeting.setTopic(mtTopic);
        meeting.setMeetingStatusId("in audit");//正在审核   
        meeting.setMeetingContent(mtContent);
        meeting.setApplyStatusId("examing");//审核中
        
        meetingMapper.insertSelective(meeting);
        
        //根据与会者列表和会议编号插入与会关系
        meetingRoomBook.getMtParticipantsIdList();
        
        
        //根据会议组织者编号、会议编号、会议室申请状态、当前时间插入会议申请
        //根据会议编号、会议室编号、开始时间和结束时间插入会议室时间安排中
        
        return null;
    }

}
