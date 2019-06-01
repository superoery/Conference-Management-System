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
     * 可以成功进行会议申请
     * apply、meeting、schedule、participates_meeting
     * 这几个表都成功地插入了对应信息
     */
    @Transactional
    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        
        Integer mtRoomId = 7;
        String organizerId = "00000001";
        MeetingRoomBook meetingRoomBook = new MeetingRoomBook();
        meetingRoomBook.setMtTopic("srtp开会");
        meetingRoomBook.setMtContent("讨论怎么设计人工智能算法");
        meetingRoomBook.setMtRoomId(mtRoomId);
        meetingRoomBook.setMtOrganizerId(organizerId);
        meetingRoomBook.setBeginTime(sdf.parse("2019-05-30 14:00"));
        meetingRoomBook.setEndTime(sdf.parse("2019-05-30 15:10"));
        
        
        List<String> mtParticipantsIdList = new ArrayList<String>();
          
        mtParticipantsIdList.add("00000002");//小明
        mtParticipantsIdList.add("00000004");//大脸妹
        mtParticipantsIdList.add("00000008");//青行灯
          
        meetingRoomBook.setMtParticipantsIdList(mtParticipantsIdList);
          
        meetingBiz.createMt(meetingRoomBook);
        
        //检查以下几个表是否成功插入数据
        //apply、meeting、schedule、participates_meeting
        
        
        
    }

}
