/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.util;

import java.util.Comparator;
import java.util.List;

/**
 * @author Mity1299
 * 比较两个列表list包含的元素是否相同，无序比较
 */
public class IsListEqual {
    
    public static <E>boolean isListEqual(List<E> list1, List<E> list2) {

        // 两个list引用相同（包括两者都为空指针的情况）
        if (list1.containsAll(list2) &&
                list2.containsAll(list1)) {
            return true;
        }else {
            return false;
        }
    }
}
