/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import team.softwarede.confersys.dto.MeetingApplyDetails;
import team.softwarede.confersys.dto.MeetingRoomBook;

/**
 * @author Mity1299
 *
 */
public interface MeetingBiz {


    boolean bookMtRoomAgain(String organizerId,Integer meetingId,MeetingRoomBook mtRoomBook);

    boolean createMt(MeetingRoomBook mtRoomBook );
    
    boolean editMeetingContent(int meetingId, String meetingContent, String meetingConclusion);
    
    MeetingApplyDetails showMtRoomBookDetails(int applyId);

}
