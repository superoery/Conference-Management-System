/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dto.MeetingRoomBook;
import team.softwarede.confersys.entity.Equipment;
import team.softwarede.confersys.entity.EquipmentType;

/**
 * @author Mity1299
 *
 */
public interface MeetingRoomBiz {

    List<MeetingRoomAvail> showAvailMtRoom(Date beginTime,
                                          Date endTime,
                                          List<Integer> equipmentTypeIdList,
                                          Integer capacity);

    List<EquipmentType> showMtRoomBookPage();
}
