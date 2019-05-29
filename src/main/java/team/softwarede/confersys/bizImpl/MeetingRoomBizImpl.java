/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.MeetingRoomBiz;
import team.softwarede.confersys.dto.MeetingRoomAvail;
import team.softwarede.confersys.dtomapper.MeetingRoomAvailMapper;

/**
 * @author Mity1299
 *
 */
@Service("meetingRoomBiz")
public class MeetingRoomBizImpl implements MeetingRoomBiz{

    @Autowired
    MeetingRoomAvailMapper meetingRoomBookMapper;
    
    @Override
    public List<MeetingRoomAvail> showAvailMtRoom(Date beginTime, 
                                                 Date endTime, 
                                                 List<Integer> equipmentTypeIdList,
                                                 Integer capacity) {
        // TODO Auto-generated method stub
        List<MeetingRoomAvail> meetingRoomBookList =
                meetingRoomBookMapper.selectBookAvailList(beginTime, endTime, equipmentTypeIdList, capacity);
        
        return meetingRoomBookList;
    }

}
