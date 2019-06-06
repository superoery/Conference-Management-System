/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.EquipmentTypeMapper;
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
    @Autowired
    EquipmentTypeMapper equipmentTypeMapper;    
    
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


    @Cacheable(value = "EquipmentTypeCache" , key = "targetClass + methodName")
    @Override
    public List<EquipmentType> showMtRoomBookPage() {
        // TODO Auto-generated method stub
        
        return equipmentTypeMapper.selectAll();
    }

}
