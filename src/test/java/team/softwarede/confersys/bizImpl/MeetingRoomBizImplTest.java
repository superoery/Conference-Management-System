/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.util.IsListEqual;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomBizImplTest {

    @Autowired
    MeetingRoomBiz meetingRoomBiz; 
    
    private SimpleDateFormat sdf;
    private Logger logger;
    
    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }
    
    /**
         * 有可预约的会议室
    * 
    */
    @Test
    public void test() {
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
        equipmentTypeIdList.add(2);
        equipmentTypeIdList.add(3);
        Integer capacity = 30;
   
        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);

          
          List<Integer> mtRoomIdListTest = new ArrayList<Integer>();
          for(MeetingRoomAvail mtavail : availList) {
              if(mtavail!=null) {
                  logger.debug("LIST "+mtavail.getId().toString());
                  mtRoomIdListTest.add(mtavail.getId());
              }
               
          }
          
        
          List<Integer> mtRoomIdListValid = new ArrayList<Integer>();
          mtRoomIdListValid.add(7); mtRoomIdListValid.add(8);
          
          boolean result = IsListEqual.isListEqual(mtRoomIdListValid,mtRoomIdListTest);
          
          assertEquals(true, result);
         
    }
    
    /**
     * 由于设备类型的原因，只有一个会议室
     */
    @Test
    public void testAvailList1Success() {
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
        Integer capacity = 30;
   
        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);

          
          List<Integer> mtRoomIdListTest = new ArrayList<Integer>();
          for(MeetingRoomAvail mtavail : availList) {
              if(mtavail!=null) {
                  logger.debug("LIST1 "+mtavail.getId().toString());
                  mtRoomIdListTest.add(mtavail.getId());
              }
               
          }
          
          if(mtRoomIdListTest.isEmpty()) {
              System.out.println("列表为空");
          }else {
              System.out.println("列表不为空");
          }
          
          List<Integer> mtRoomIdListValid = new ArrayList<Integer>();
          mtRoomIdListValid.add(8);
          
          boolean result = IsListEqual.isListEqual(mtRoomIdListValid,
          mtRoomIdListTest);
          
          assertEquals(true, result);

    }
    
    /**
     * 没有可预约的会议室
     * 开始时间与上一个会议时间重叠
     */
    @Test
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
        equipmentTypeIdList.add(3);
        equipmentTypeIdList.add(2);
        Integer capacity = 30;
        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);
        for(MeetingRoomAvail m : availList) {
            if(m!=null) {
                logger.debug("BeginTime"+m.getId().toString());
            }
        }
        
        assertEquals(true, availList.isEmpty());  
    }
    
    /**
     * 没有可预约的会议室
     * 结束时间与下一会议时间重叠
     */
    @Test
    public void testAvailListEndTimeError() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:45");
            endTime = sdf.parse("2019-05-30 10:30");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(3);
        equipmentTypeIdList.add(2);
        Integer capacity = 30;
        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);
        for(MeetingRoomAvail m : availList) {
            if(m!=null) {
                logger.debug("BeginTime"+m.getId().toString());
            }
        }
        
        assertEquals(true, availList.isEmpty());  
    }
    
    /**
     * 没有可预约的会议室
     * 与会人数过多
     * @throws ParseException 
     */
    @Test
    public void testAvailListNumberError() throws ParseException {
        Date beginTime = null;
        Date endTime = null;

            beginTime = sdf.parse("2019-05-30 08:45");
            endTime = sdf.parse("2019-05-30 09:30");
        
        System.out.println(beginTime);
        
        System.out.println(sdf.format(beginTime));

        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(3);
        equipmentTypeIdList.add(2);
        Integer capacity = 100;
        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);
     
        
        assertEquals(true, availList.isEmpty());  
    }
    
    /**
     * 插入会议中间的时间
     */
    @Test
    public void testInsertMid() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 10:30");
            endTime = sdf.parse("2019-05-30 11:00");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(2);
        equipmentTypeIdList.add(3);
        Integer capacity = 30;

        List<MeetingRoomAvail> availList = meetingRoomBiz.showAvailMtRoom(beginTime, endTime, equipmentTypeIdList, capacity);
      
      List<Integer> mtRoomIdListTest = new ArrayList<Integer>();
      for(MeetingRoomAvail mtavail : availList) {
          if(mtavail!=null) {
              logger.debug("LISTMid "+mtavail.getId().toString());
              mtRoomIdListTest.add(mtavail.getId());
          }
           
      }
      
      assertEquals(true, availList.isEmpty());  

    }
      
    
    
}