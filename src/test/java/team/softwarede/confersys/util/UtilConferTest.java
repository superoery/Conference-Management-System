/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class UtilConferTest {

    /**
     * 测试列表去重
     */
    @Test
    public void test() {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> listTotal = new ArrayList<Integer>();
        
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        
        list2.add(1);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        
        listTotal.addAll(list1);
        listTotal.addAll(list2);
        
        
        UtilConfer.removeDuplicate(listTotal);
        
        assertEquals(7, listTotal.size());
        
        
    
    }
    

}
