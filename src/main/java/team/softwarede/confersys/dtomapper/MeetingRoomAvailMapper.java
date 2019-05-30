/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dtomapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.MeetingRoomAvail;

/**
 *
 */
@Mapper
public interface MeetingRoomAvailMapper {

    List<MeetingRoomAvail> selectBookAvailList(@Param("beginTime") Date beginTime,
                                              @Param("endTime") Date endTime,
                                              @Param("equipmentTypeIdList") List<Integer> equipmentTypeIdList,
                                              @Param("capacity") Integer capacity);
    
}
