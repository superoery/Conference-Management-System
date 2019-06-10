/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;


import java.util.List;

import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.dto.NotificationMainPage;


/**
 * @author Mity1299
 *
 */
public interface InformBiz {

    
    boolean auditMeeingBookApply(Integer mtRoomApplyId, Integer bookStatus);
    
    NotificationDetail showNormalInformDetail(Integer informId);
    
    boolean alterInformHaveRead (Integer informId);
    
    List<NotificationMainPage> notificationNewMeeting(String userId, int roleId);

}
