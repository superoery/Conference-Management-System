package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingDetailBiz;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.MeetingDetailWithoutParticipantsList;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
import team.softwarede.confersys.dtomapper.ShowMeetingDetail2Mapper;
import team.softwarede.confersys.dtomapper.ShowMeetingDetail3Mapper;
import team.softwarede.confersys.dtomapper.ShowMeetingDetailMapper;
/**
 * 
 * @author SunRonglin
 *
 */
@Service("showMeetingDetailBiz")
public class ShowMeetingDetailBizImpl implements ShowMeetingDetailBiz{
	//显示会议参与人员信息列表
	@Autowired
	ShowMeetingDetailMapper showMeetingDetailMapper;
	@Override
	public List<ParticipantBasicInfo> showMeetingDetail(int meetingId) {
		List<ParticipantBasicInfo> participantBasicInfo = showMeetingDetailMapper.selectByMeetingId(meetingId);
		return participantBasicInfo;
	}
}
