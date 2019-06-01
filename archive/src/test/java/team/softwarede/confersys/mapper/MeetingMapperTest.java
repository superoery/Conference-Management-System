/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.exceptions.util.ScenarioPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;
import team.softwarede.confersys.entity.Meeting;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.entity.Schedule;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.enums.EnumMeetingRoomStatusId;
import team.softwarede.confersys.enums.EnumMeetingStatusId;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingMapperTest {

    @Autowired
    MeetingRoomAvailMapper meetingRoomBookMapper; 
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    MeetingMapper meetingMapper; 

    
    
    private SimpleDateFormat sdf;
    private Logger logger;
    
    
    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @Test
    @Transactional
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Integer size = 2;
        Meeting[] meetingArray = new Meeting[size];
        Schedule[] scheduleArray = new Schedule[size];
        
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(7);
        
        Meeting meeting = new Meeting();
          //插入会议
          meeting = new Meeting();
          meeting.setTopic("how to graduate");
          meeting.setNumber(20);
          meeting.setMeetingContent("this meeting is about graduation.");
          meeting.setMeetingConclusion("study harder!");
          meeting.setApplyStatusId(EnumApplyStatusId.SUCCEED.getDescription());
          meeting.setMeetingStatusId(EnumMeetingStatusId.READY.getDescription());

          meetingMapper.insertSelective(meeting);
          
          //插入日程
          Schedule schedule = new Schedule();
          schedule.setMeetingId(meeting.getId());//插入会议的自增长id
          schedule.setMeetingRoomId(meetingRoom.getId());
          
          try {
              schedule.setBeginTime(sdf.parse("2019-05-30 12:00"));
              schedule.setEndTime(sdf.parse("2019-05-30 14:30"));
          } catch (ParseException e) {
              // TODO Auto-generated catch block
          e.printStackTrace();
          logger.error("创建日期错误");
          }
          scheduleMapper.insertSelective(schedule);

          
          
    }

    
    
    @Test
    public void initMeeting() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Integer size = 2;
        Meeting[] meetingArray = new Meeting[size];
        Schedule[] scheduleArray = new Schedule[size];
        
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(8);
        
        Meeting meeting = new Meeting();
          //插入会议
          meeting = new Meeting();
          meeting.setTopic("how to graduate");
          meeting.setNumber(20);
          meeting.setMeetingContent("this meeting is about graduation.");
          meeting.setMeetingConclusion("study harder!");
          meeting.setApplyStatusId(EnumApplyStatusId.SUCCEED.getDescription());
          meeting.setMeetingStatusId(EnumMeetingStatusId.READY.getDescription());

          meetingMapper.insertSelective(meeting);
          
          //插入日程
          Schedule schedule = new Schedule();
          schedule.setMeetingId(meeting.getId());//插入会议的自增长id
          schedule.setMeetingRoomId(meetingRoom.getId());
          
          try {
              schedule.setBeginTime(sdf.parse("2019-05-10 7:00"));
              schedule.setEndTime(sdf.parse("2019-05-10 8:30"));
          } catch (ParseException e) {
              // TODO Auto-generated catch block
          e.printStackTrace();
          logger.error("创建日期错误");
          }
          
          meetingArray[0]=meeting;          
          scheduleArray[0]=schedule;

          
          //插入第二个会议
          meeting = new Meeting();
          meeting.setTopic("how to work");
          meeting.setNumber(30);
          meeting.setMeetingContent("this meeting2 is about work.");
          meeting.setMeetingConclusion("work harder!");
          meeting.setApplyStatusId(EnumApplyStatusId.SUCCEED.getDescription());
          meeting.setMeetingStatusId(EnumMeetingStatusId.READY.getDescription());
                  
          meetingMapper.insertSelective(meeting);
          
          schedule = new Schedule();
          schedule.setMeetingId(meeting.getId());//插入会议的自增长id
          schedule.setMeetingRoomId(meetingRoom.getId());//插入会议室的自增长id
          
          try {
              schedule.setBeginTime(sdf.parse("2019-05-10 10:00"));
              schedule.setEndTime(sdf.parse("2019-05-10 11:10"));
          } catch (ParseException e) {
              // TODO Auto-generated catch block
          e.printStackTrace();
          logger.error("创建日期错误");
          }
          
          meetingArray[1]=meeting;
          scheduleArray[1]=schedule;
          
          for(Schedule s : scheduleArray) {
              if(s!=null) {
                  scheduleMapper.insertSelective(s);
              }
          }
          
          
    }

}
