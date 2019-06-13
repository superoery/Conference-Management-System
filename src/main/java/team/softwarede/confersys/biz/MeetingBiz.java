/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingApplyDetails;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.dto.MeetingRoomSchedule;
import team.softwarede.confersys.dto.MeetingRoomScheduleOrg;

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
