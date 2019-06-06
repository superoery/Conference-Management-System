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
import org.junit.Ignore;
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
import team.softwarede.confersys.entity.EquipmentType;
import team.softwarede.confersys.enums.EnumApplyStatusId;
import team.softwarede.confersys.util.IsListEqual;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomBizImplShowTest {

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
     * 显示预约界面，返回所有设备类型
     */
    @Ignore
    public void testShowPage() {
        List<EquipmentType> equipmentTypeList = meetingRoomBiz.showMtRoomBookPage();
        
        assertEquals(4, equipmentTypeList.size());
        
    }
    
    /**
     * 测试缓存
     */
    @Test
    public void testShowPageCache() {
        
        List<EquipmentType> equipmentTypeList1 = meetingRoomBiz.showMtRoomBookPage();
        
        assertEquals(4, equipmentTypeList1.size());

        List<EquipmentType> equipmentTypeList2 = meetingRoomBiz.showMtRoomBookPage();
        
        assertEquals(4, equipmentTypeList2.size());

        
        
    }
    
}