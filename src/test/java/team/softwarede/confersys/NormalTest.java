/**
* 
* @author Mity1299
*/
package team.softwarede.confersys;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class NormalTest {

    
    
    private Logger logger;
    
    @Before
    public void setUp() {
        logger = Logger.getLogger(getClass());
    
    }
    
    /**
     * 测试失败，两个数组不一样
     */
    @Ignore
    public void testArrayEquals() {
        int[] intArrayTest= {1,2};
        int[] intArrayValid= {2,1};
        assertArrayEquals(intArrayTest, intArrayValid);
    }
    
    /**
     * 测试失败，两个列表不一样
     */
    @Ignore
    public void testListEquals() {
        List<Integer> intListTest = new ArrayList<Integer>();
        intListTest.add(1);
        intListTest.add(2);
        List<Integer> intListValid = new ArrayList<Integer>();
        intListValid.add(2);       
        intListValid.add(1);
        
        assertEquals(intListValid, intListTest);
    
    }
    
    /**
     * 测试成功，两个列表一样
     */
    @Test
    public void testListEqualsContainSuccess() {
        List<Integer> intListTest = new ArrayList<Integer>();
        intListTest.add(1);
        intListTest.add(2);
        List<Integer> intListValid = new ArrayList<Integer>();
        intListValid.add(2);       
        intListValid.add(1);
        
        if (intListTest.containsAll(intListValid) &&
                intListValid.containsAll(intListTest)) {
            logger.info("两个列表相同");
        }else {
            logger.info("两个列表不相同");
        }
    
    }
    
    /**
     * 测试成功，两个列表不一样的情况
     */
    @Test
    public void testListEqualsContainError() {
        List<Integer> intListTest = new ArrayList<Integer>();
        intListTest.add(1);
        intListTest.add(2);
        List<Integer> intListValid = new ArrayList<Integer>();
        intListValid.add(3);       
        intListValid.add(1);
        
        if (intListTest.containsAll(intListValid) &&
                intListValid.containsAll(intListTest)) {
            logger.info("两个列表相同");
        }else {
            logger.info("两个列表不相同");
        }
    
    }
    

}
