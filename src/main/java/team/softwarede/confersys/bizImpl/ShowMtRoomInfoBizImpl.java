package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMtRoomInfoBiz;
import team.softwarede.confersys.entity.MeetingRoom;
import team.softwarede.confersys.mapper.MeetingRoomMapper;

/**
 * 
 * @author SunRonglin
 *
 */
@Service("ShowMtRoomInfoBiz")
public class ShowMtRoomInfoBizImpl implements ShowMtRoomInfoBiz{
	@Autowired
	MeetingRoomMapper meetingRoomMapper;
	
	@Override
	public MeetingRoom showMtRoomInfo(int meetingId) {
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom = meetingRoomMapper.selectByPrimaryKey(meetingId);
		return meetingRoom;
	}
}
