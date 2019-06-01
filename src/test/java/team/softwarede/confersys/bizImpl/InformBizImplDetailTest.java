/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.enums.EnumNotificationType;
import team.softwarede.confersys.mapper.NotificationMapper;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformBizImplDetailTest {

    @Autowired
    InformBiz informBiz;
    @Autowired
    NotificationMapper notificationMapper; 
    
    /**
     * 测试“新会议”类型
     */
    @Test
    public void testNewMeeting() {
        NotificationDetail detail = informBiz.showNormalInformDetail(3);
        assertEquals(EnumNotificationType.MEETING.getDescription(), detail.getNoteType());
        assertEquals("srtp开会", detail.getNoteReferMtName());
        
    }
    
    /**
     * 测试“审核结果”
     */
    @Test
    public void testAuidit() {
        NotificationDetail detail = informBiz.showNormalInformDetail(8);
        assertEquals(EnumNotificationType.AUIDIT.getDescription(), detail.getNoteType());
        assertEquals("how to work", detail.getNoteReferMtName());
        
    }
    
    /**
     * 测试“报修”类型
     */
    @Test
    public void testRepair() {
        NotificationDetail detail = informBiz.showNormalInformDetail(6);
        assertEquals(EnumNotificationType.REPAIR.getDescription(), detail.getNoteType());
        assertEquals(null, detail.getNoteReferMtName());
        
    }
    
    /**
     * 测试“请假”类型
     */
    @Test 
    public void testLeave() {
        NotificationDetail detail = informBiz.showNormalInformDetail(5);
        assertEquals("srtp开会", detail.getNoteReferMtName());
    }

    
    

    
    
}
