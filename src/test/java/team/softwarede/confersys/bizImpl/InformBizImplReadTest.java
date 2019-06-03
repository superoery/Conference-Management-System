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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.biz.InformBiz;
import team.softwarede.confersys.entity.Notification;
import team.softwarede.confersys.enums.EnumNotificationStatus;
import team.softwarede.confersys.mapper.NotificationMapper;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformBizImplReadTest {

    @Autowired
    InformBiz informBiz;
    @Autowired
    NotificationMapper notificationMapper;
    
    /**
     * 测试修改通知为已读
     */
    @Test 
    public void testReadInfo() {
        informBiz.alterInformHaveRead(5);
        Notification notification = notificationMapper.selectByPrimaryKey(5);
       
        assertEquals(EnumNotificationStatus.READ.getDescription(), notification.getNotificationnStatus());
       
    }
}
