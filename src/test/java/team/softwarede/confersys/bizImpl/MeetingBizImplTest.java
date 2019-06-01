/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

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

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.MeetingBiz;
import team.softwarede.confersys.dto.MeetingRoomBook;

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
    
    @Ignore
    public void testAfter() throws ParseException {
        MeetingRoomBook meetingRoomBook = new MeetingRoomBook();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String organizerId = "00000001";//王老师
        Integer meetingId= 14;

        //将结束时间从2019-05-30 15:10改成了2019-05-30 16:00
        meetingRoomBook.setMtContent("讨论怎么将人工智能应用到医疗领域");
        meetingRoomBook.setEndTime(sdf.parse("2019-05-30 16:00"));//没插进来！！！！！！！
        
        
        List<String> mtParticipantsIdList = new ArrayList<String>();
          
        //相比之前删掉了小明 00000002，添加了夜叉00000009，美美老师,保留了大脸妹00000004
        mtParticipantsIdList.add("00000004");//大脸妹
        mtParticipantsIdList.add("00000008");//青行灯
        mtParticipantsIdList.add("00000009");//夜叉
        mtParticipantsIdList.add("00000011");//美美老师
          
        meetingRoomBook.setMtParticipantsIdList(mtParticipantsIdList);

        meetingBiz.bookMtRoomAgain(organizerId, meetingId, meetingRoomBook);
    }
    
    @Test
    public void testBefore() throws ParseException {
        MeetingRoomBook meetingRoomBook = new MeetingRoomBook();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String organizerId = "00000001";//王老师
        Integer meetingId= 14;
        Integer meetingRoom = 8;

        //将结束时间从2019-05-30 15:10改成了2019-05-30 16:00
        meetingRoomBook.setMtContent("讨论怎么实现人工智能");
        meetingRoomBook.setEndTime(sdf.parse("2019-05-30 18:00"));//没插进来！！！！！！！
        
        
        List<String> mtParticipantsIdList = new ArrayList<String>();
          
        
        mtParticipantsIdList.add("00000004");//大脸妹
        mtParticipantsIdList.add("00000008");//青行灯
        mtParticipantsIdList.add("00000002");//小明
        
          
        meetingRoomBook.setMtParticipantsIdList(mtParticipantsIdList);

        meetingBiz.bookMtRoomAgain(organizerId, meetingId, meetingRoomBook);
    }

}
