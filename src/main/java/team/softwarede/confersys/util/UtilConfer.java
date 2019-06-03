/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.util;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * 本项目用到的工具类
 * @author Mity1299
 * */
public class UtilConfer {
    
    /**
     * list去重
     * @param <T>
     * @param list
     */
    public static<T> void removeDuplicate(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<T>(list.size());
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }

}
