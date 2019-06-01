/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import team.softwarede.confersys.dto.MeetingRoomBook;

/**
 * @author Mity1299
 *
 */
public interface MeetingBiz {

    boolean bookMtRoomAgain(String organizerId,Integer meetingId,MeetingRoomBook mtRoomBook);
}
