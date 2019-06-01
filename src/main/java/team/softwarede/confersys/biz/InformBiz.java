/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import team.softwarede.confersys.dto.NotificationDetail;

/**
 * @author Mity1299
 *
 */
public interface InformBiz {
    
    NotificationDetail showNormalInformDetail(Integer informId);
    
    boolean alterInformHaveRead (Integer informId);
}
