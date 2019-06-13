/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.EquipmentRepairDetails;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomSchedule;
import team.softwarede.confersys.dto.MeetingRoomScheduleOrg;
import team.softwarede.confersys.dtomapper.EquipmentRepairDetailsMapper;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.mapper.ApplyMapper;
import team.softwarede.confersys.mapper.EquipmentTypeMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.ParticipatesMapper;
import team.softwarede.confersys.mapper.ScheduleMapper;


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
    @Autowired
    EquipmentRepairDetailsMapper equipmentRepairDetailsMapper;
    @Autowired
    MeetingRoomAvailMapper meetingRoomAvailMapper;
    
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
    
    @Override
    public EquipmentRepairDetails repairDetails(int repairId) {
    	EquipmentRepairDetails repairDetails = equipmentRepairDetailsMapper.showEquipmentDetail(repairId);
    	return repairDetails;
    }
    
    @Override
    public List<MeetingRoomAvail> showAllMtRoom(){
    	List<MeetingRoomAvail> MtRoomList = meetingRoomAvailMapper.selectAllMtRoomList();
    	return MtRoomList;
    }
    
    @Override
    public List<MeetingRoomSchedule> showScheduleAdmin(int meetingRoomId){
    	
    	Schedule item = new Schedule();
    	List<Schedule> schedule= scheduleMapper.selectByMeetingRoomId(meetingRoomId);
    	List<MeetingRoomSchedule> list = new ArrayList();
    	
    	for(int i = 0; i < schedule.size(); i++) {
    		item = schedule.get(i);
    		MeetingRoomSchedule showItem = new MeetingRoomSchedule();
    		showItem.setBeginTime(item.getBeginTime());
    		showItem.setEndTime(item.getEndTime());
    		showItem.setMtId(item.getMeetingId());
    		showItem.setMtTopic(meetingMapper.selectTopicById(item.getMeetingId()));
    		list.add(showItem);

    	}
    	return list;
    }
    
    @Override
    public List<MeetingRoomScheduleOrg> showScheduleOrg(int meetingRoomId){
    	Schedule item = new Schedule();
    	List<Schedule> schedule= scheduleMapper.selectByMeetingRoomId(meetingRoomId);
    	List<MeetingRoomScheduleOrg> list = new ArrayList();
    	for(int i = 0; i < schedule.size(); i++) {
    		item = schedule.get(i);
    		MeetingRoomScheduleOrg showItem = new MeetingRoomScheduleOrg();
    		showItem.setBeginTime(item.getBeginTime());
    		showItem.setEndTime(item.getEndTime());
    		list.add(showItem);
    	}
    	return list;
    }

}
