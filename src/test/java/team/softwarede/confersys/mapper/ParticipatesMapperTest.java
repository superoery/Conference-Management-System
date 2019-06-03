/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Participates;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ParticipatesMapperTest {

    @Autowired
    ParticipatesMapper participatesMapper;
    
    /**
     * 测试根据会议编号查找participates列表
     */
    @Test
    public void test() {
        Integer meetingId = 14;
        List<String> partList = participatesMapper.selectByMtId(meetingId);
        assertEquals(4, partList.size());
        
    }

}
