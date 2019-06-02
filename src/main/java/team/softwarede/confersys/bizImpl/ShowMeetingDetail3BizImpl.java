package team.softwarede.confersys.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingDetail3Biz;
import team.softwarede.confersys.dto.MeetingDetailWithoutParticipantsList;
import team.softwarede.confersys.dtomapper.ShowMeetingDetail3Mapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("showMeetingDetail3Biz")
public class ShowMeetingDetail3BizImpl implements ShowMeetingDetail3Biz{
	//普通用户返回的会议详情
	@Autowired
	ShowMeetingDetail3Mapper showMeetingDetail3Mapper;
	@Override
	public MeetingDetailWithoutParticipantsList showMeetingDetail3(int meetingId){
		MeetingDetailWithoutParticipantsList list = showMeetingDetail3Mapper.normalSelectByMeetingId(meetingId);
		return list;
	}
}
