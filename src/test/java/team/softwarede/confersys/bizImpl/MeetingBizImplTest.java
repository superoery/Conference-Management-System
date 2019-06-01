/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.entity.MeetingRoom;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingBizImplTest {

    @Autowired
    MeetingBiz meetingBiz;
    
    
    /*
     * 测试用户编号为0开头的情况
     * 通过测试
     */
    
    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        
        Integer mtRoomId = 7;
        String organizerId = "00000009";
        MeetingRoomBook meetingRoomBook = new MeetingRoomBook();
        meetingRoomBook.setMtTopic("党团开会");
        meetingRoomBook.setMtContent("讨论怎么实现美好未来");
        meetingRoomBook.setMtRoomId(mtRoomId);
        meetingRoomBook.setMtOrganizerId(organizerId);
        meetingRoomBook.setBeginTime(sdf.parse("2019-05-30 20:00"));
        meetingRoomBook.setEndTime(sdf.parse("2019-05-30 21:10"));
        
        
        List<String> mtParticipantsIdList = new ArrayList<String>();
          
        
        List<Integer> mtPartUGroupIdList = new ArrayList<Integer>();
        mtPartUGroupIdList.add(7);
        meetingRoomBook.setuGroupIdList(mtPartUGroupIdList);
          
        meetingRoomBook.setMtParticipantsIdList(mtParticipantsIdList);
          
        meetingBiz.createMt(meetingRoomBook);
        
        //检查以下几个表是否成功插入数据
        //apply、meeting、schedule、participate

    }

    
    /**
     * 填写会议信息，预约会议室
     * 测试通过
     * @throws ParseException
     */
    @Ignore
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        
        Integer mtRoomId = 8;
        String organizerId = "10000007";
        MeetingRoomBook meetingRoomBook = new MeetingRoomBook();
        meetingRoomBook.setMtTopic("软件工程实现");
        meetingRoomBook.setMtContent("讨论怎么实现软件工程课程的项目");
        meetingRoomBook.setMtRoomId(mtRoomId);
        meetingRoomBook.setMtOrganizerId(organizerId);
        meetingRoomBook.setBeginTime(sdf.parse("2019-05-30 14:00"));
        meetingRoomBook.setEndTime(sdf.parse("2019-05-30 15:10"));
        
        
        List<String> mtParticipantsIdList = new ArrayList<String>();
          
        mtParticipantsIdList.add("10000002");//小明
        mtParticipantsIdList.add("10000004");//大脸妹
        mtParticipantsIdList.add("10000008");//青行灯
        
        List<Integer> mtPartUGroupIdList = new ArrayList<Integer>();
        mtPartUGroupIdList.add(6);
        mtPartUGroupIdList.add(2);
        meetingRoomBook.setuGroupIdList(mtPartUGroupIdList);
          
        meetingRoomBook.setMtParticipantsIdList(mtParticipantsIdList);
          
        meetingBiz.createMt(meetingRoomBook);
        
        //检查以下几个表是否成功插入数据
        //apply、meeting、schedule、participate
        
        
        
    }

}
