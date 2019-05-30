/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dtomapper;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.entity.MeetingRoomSchedule;
import team.softwarede.confersys.enums.EnumMeetingRoomStatusId;
import team.softwarede.confersys.enums.EnumMeetingStatusId;
import team.softwarede.confersys.mapper.EquipmentMapper;
import team.softwarede.confersys.mapper.EquipmentTypeMapper;
import team.softwarede.confersys.mapper.MeetingMapper;
import team.softwarede.confersys.mapper.MeetingRoomMapper;
import team.softwarede.confersys.mapper.MeetingRoomScheduleMapper;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class MeetingRoomBookMapperTest {
    
    @Autowired
    MeetingRoomAvailMapper meetingRoomBookMapper; 
    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    @Autowired
    MeetingRoomScheduleMapper meetingRoomScheduleMapper;
    @Autowired
    MeetingMapper meetingMapper; 
    @Autowired
    EquipmentMapper equipmentMapper;
    @Autowired
    EquipmentTypeMapper equipmentTypeMapper;
    
    
    private SimpleDateFormat sdf;
    private Logger logger;
    private Meeting meeting;
    private Meeting meeting2;
    private MeetingRoom meetingRoom;
    
    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @Transactional //开启事务
    @Before 
    public void initMeeting() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        //插入会议室
        meetingRoom = new MeetingRoom();
        meetingRoom.setId(2);
        meetingRoom.setBuilding("逸夫楼");
        meetingRoom.setCapacity(40);
        meetingRoom.setFloor(3);
        meetingRoom.setRoomNumber("4");
        meetingRoom.setRoomIntroduce("I'm 304");
        meetingRoom.setStatusId(EnumMeetingRoomStatusId.FREE.toString());
        
        meetingRoomMapper.insertSelective(meetingRoom);
        
      //插入会议
        meeting = new Meeting();
        meeting.setId(2);//由于现在不是自动增长，因此需要我手动添加一个id
        meeting.setTopic("how to graduate");
        meeting.setNumber(30);
        meeting.setMeetingContent("this meeting is about graduation.");
        meeting.setMeetingConclusion("study harder!");
        meeting.setMeetingStatusId( EnumMeetingStatusId.EXAMING.toString());
        
        meetingMapper.insertSelective(meeting);
        
        //插入日程
        
        MeetingRoomSchedule schedule = new MeetingRoomSchedule();
        schedule.setMeetingId(meeting.getId());//插入会议的自增长id
        schedule.setMeetingRoomId(meetingRoom.getId());//插入会议室的自增长id
        
        try {
            schedule.setBeginTime(sdf.parse("2019-05-10 7:00"));
            schedule.setEndTime(sdf.parse("2019-05-10 8:30"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("创建日期错误");
        }
        
        //补充meeting里的schedue的外键
        Meeting meetingTemp = new Meeting();
        meetingTemp.setId(meeting.getId());
        meetingTemp.setMeetingId(schedule.getMeetingId());
        meetingMapper.updateByPrimaryKeySelective(meetingTemp);
        
        
        //插入第二个会议
        meeting2 = new Meeting();
        meeting2.setId(2);//由于现在不是自动增长，因此需要我手动添加一个id
        meeting2.setTopic("how to graduate");
        meeting.setNumber(30);
        meeting2.setMeetingContent("this meeting2 is about graduation.");
        meeting2.setMeetingConclusion("study harder!");
        meeting2.setMeetingStatusId( EnumMeetingStatusId.EXAMING.toString());
        
        meetingMapper.insertSelective(meeting2);
                
        MeetingRoomSchedule schedule2 = new MeetingRoomSchedule();
        schedule2.setMeetingId(meeting2.getId());//插入会议的自增长id
        schedule2.setMeetingRoomId(meetingRoom.getId());//插入会议室的自增长id
        
        try {
            schedule2.setBeginTime(sdf.parse("2019-05-10 10:00"));
            schedule2.setEndTime(sdf.parse("2019-05-10 11:10"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("创建日期错误");
        }
        
        //补充meeting里的schedue的外键
        Meeting meetingTemp2 = new Meeting();
        meetingTemp2.setId(meeting.getId());
        meetingTemp2.setMeetingId(schedule2.getMeetingId());
        meetingMapper.updateByPrimaryKeySelective(meetingTemp2);
        
        
        //插入设备和设备类型
        
    }

    
    
    /**
          * 有可预约的会议室
     * 
     */
    @Test
    public void testAvailListSuccess() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:45");
            endTime = sdf.parse("2019-05-30 09:30");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(1);
        equipmentTypeIdList.add(2);
        Integer capacity = 30;
        List<MeetingRoomAvail> availList =meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
        assertEquals(meetingRoom.getId(), availList.get(1).getId());  
    }
    
    /**
     * 没有可预约的会议室
     * 开始时间与上一个会议时间重叠
     */
    public void testAvailListBeginError() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:00");
            endTime = sdf.parse("2019-05-30 09:30");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(1);
        equipmentTypeIdList.add(2);
        Integer capacity = 30;
        List<MeetingRoomAvail> availList =meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
        assertEquals(null, availList);
    }
    
    /**
     * 没有可预约的会议室
     * 结束时间与下一会议时间重叠
     */
    public void testAvailListNumberError() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:45");
            endTime = sdf.parse("2019-05-30 10:15");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(1);
        equipmentTypeIdList.add(2);
        
        Integer capacity = 30;
        List<MeetingRoomAvail> availList =meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
        assertEquals(null, availList);
    }
    
    /**
     * 没有可预约的会议室
     * 与会人数过多
     */
    @Test
    public void testAvailListNumbserError() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:45");
            endTime = sdf.parse("2019-05-30 09:30");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(1);
        equipmentTypeIdList.add(2);
        Integer capacity = 50;
        List<MeetingRoomAvail> availList =meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
        assertEquals(null, availList);  
    }


    
}
