package team.softwarede.confersys.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingDetail2Biz;
import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.ParticipantBasicInfo;
import team.softwarede.confersys.dtomapper.ShowMeetingDetail2Mapper;
import team.softwarede.confersys.dtomapper.ShowMeetingDetailMapper;

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
	public MeetingDetail showMeetingDetail2(String userId, int meetingId,int roleId) {
		if(roleId == 1 || roleId == 3){
			MeetingDetail list = showMeetingDetail2Mapper.selectByMeetingId(userId, meetingId);
			return list;
		}else {
			MeetingDetail list = showMeetingDetail2Mapper.selectByMeetingId(userId, meetingId);
			return list;
		}
	}
	//显示会议参与人员信息列表
	@Autowired
	ShowMeetingDetailMapper showMeetingDetailMapper;
	@Override
	public List<ParticipantBasicInfo> showMeetingDetail(int meetingId, int roleId) {
		if(roleId == 1 || roleId == 2){
			List<ParticipantBasicInfo> participantBasicInfo = showMeetingDetailMapper.selectByMeetingId(meetingId);
			return participantBasicInfo;
		}else {
			return null;
		}
	}

}
