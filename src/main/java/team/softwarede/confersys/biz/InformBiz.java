/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;


import java.util.List;

import team.softwarede.confersys.dto.NotificationDetail;
import team.softwarede.confersys.dto.NotificationSpIntro;


/**
 * @author Mity1299
 *
 */
public interface InformBiz {

    /**
     * 审核会议室申请
     * @param mtRoomApplyId
     * @param bookStatus 0为拒绝，1为通过
     * @return
     */
    boolean auditMeeingBookApply(Integer mtRoomApplyId, Integer bookStatus);
    
    NotificationDetail showNormalInformDetail(Integer informId);
    
    boolean alterInformHaveRead (Integer informId);
    
//    List<NotificationSpIntro> showNotificationSpList(String userId); 
    
}
