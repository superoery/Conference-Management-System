package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dtomapper.ShowMeetingDetail2Mapper;

/**
 * 
 * @author SunRonglin
 *
 */
@Service("showMeetingDetail2Biz")
public class ShowMeetingDetail2BizImpl implements ShowMeetingDetail2Biz{
	//会议组织者&管理员返回的会议详情
	@Autowired
	ShowMeetingDetail2Mapper showMeetingDetail2Mapper;
	
	@Override
	public MeetingDetail showMeetingDetail2(int meetingId,int roleId) {
		if(roleId == 1){
			MeetingDetail list = showMeetingDetail2Mapper.selectByMeetingId(meetingId);
			return list;
		}else {
			MeetingDetail list = showMeetingDetail2Mapper.selectByMeetingId(meetingId);
			list.setMyParticipantStatus(null);
			return list;
		}
	}

}
