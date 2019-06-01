/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.enums.EnumMeetingRoomStatusId;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomMapperTest {

    @Autowired
    MeetingRoomMapper meetingRoomMapper; 
    
    @Ignore
    public void testInsert() {
        MeetingRoom mtRoomTemp = new MeetingRoom(); 
        //插入会议室
        mtRoomTemp.setBuilding("逸夫楼");
        mtRoomTemp.setCapacity(40);
        mtRoomTemp.setFloor(6);
        mtRoomTemp.setRoomNumber("4");
        mtRoomTemp.setRoomIntroduce("I'm 604");
        mtRoomTemp.setStatusId(EnumMeetingRoomStatusId.FREE.getDescription());
        
        meetingRoomMapper.insertSelective(mtRoomTemp);
        
    }
    
    @Test
    public void test() {
        Integer size = 2;
        MeetingRoom[] mtRoomArray = new MeetingRoom[size];
        
        MeetingRoom mtRoomTemp = new MeetingRoom(); 
        //插入会议室
        mtRoomTemp.setBuilding("逸夫楼");
        mtRoomTemp.setCapacity(40);
        mtRoomTemp.setFloor(6);
        mtRoomTemp.setRoomNumber("4");
        mtRoomTemp.setRoomIntroduce("I'm 604");
        mtRoomTemp.setStatusId(EnumMeetingRoomStatusId.FREE.getDescription());
        
        mtRoomArray[0]=mtRoomTemp;
  
        //插入会议室
        mtRoomTemp = new MeetingRoom(); 
       
        mtRoomTemp.setBuilding("机电楼");
        mtRoomTemp.setCapacity(70);
        mtRoomTemp.setFloor(1);
        mtRoomTemp.setRoomNumber("4");
        mtRoomTemp.setRoomIntroduce("I'm 104");
        mtRoomTemp.setStatusId(EnumMeetingRoomStatusId.FREE.getDescription());
        
        mtRoomArray[1]=mtRoomTemp;
        
        for(MeetingRoom mtRoom: mtRoomArray) {
            meetingRoomMapper.insertSelective(mtRoom);
        }
        
        
    }

}
