/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dtomapper;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mysql.fabric.xmlrpc.base.Data;
import team.softwarede.confersys.dto.MeetingRoomAvail;

/**
 *
 */
@Mapper
public interface MeetingRoomAvailMapper {



      List<MeetingRoomAvail> selectBookAvailList(@Param("beginTime") Date beginTime,
                                                 @Param("endTime") Date endTime,
                                                 @Param("typeIdlist") List<Integer> equipmentTypeIdList,
                                                 @Param("capacity") Integer capacity,
                                                 @Param("applyStatusId") String applyStatusId);


      

    
}
