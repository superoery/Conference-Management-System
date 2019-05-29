/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dtomapper;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRoomBookMapperTest {
    
    @Autowired
    MeetingRoomAvailMapper meetingRoomBookMapper; 
    
    private SimpleDateFormat sdf;
    
    @Before
    public void setUp() {
        
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @Test
    public void test() {
        Date beginTime = null;
        Date endTime = null;
        try {
            beginTime = sdf.parse("2019-05-30 08:00:00");
            endTime = sdf.parse("2019-05-30 09:30:00");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Integer> equipmentTypeIdList = new ArrayList<Integer>();
        equipmentTypeIdList.add(1);
        equipmentTypeIdList.add(2);
        Integer capacity = 30;
        meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
    }

}
