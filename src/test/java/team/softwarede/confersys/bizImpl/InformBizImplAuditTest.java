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

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InformBizImplAuditTest {

    @Autowired
    InformBiz informBiz;
    
    /**
     * 拒绝了会议预约,测试通过
     */
    @Rollback
    @Test
    public void testSuccess() {
        Integer mtRoomApplyId =2;
        Integer bookStatus = 0;
        informBiz.auditMeeingBookApply(mtRoomApplyId, bookStatus);
        
        
    }
    
    /**
     * 通过了会议预约，测试通过
     */
    @Rollback
    @Test
    public void testFail() {
        Integer mtRoomApplyId =2;
        Integer bookStatus = 1;
        informBiz.auditMeeingBookApply(mtRoomApplyId, bookStatus);
        
        
    }


}
