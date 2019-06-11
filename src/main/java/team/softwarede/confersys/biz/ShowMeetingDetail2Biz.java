package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.ParticipantBasicInfo;

/**
 * 
 * @author SunRonglin
 *
 */
public interface ShowMeetingDetail2Biz {
	//会议组织者&管理员返回的会议详情
	MeetingDetail showMeetingDetail2(String userId, int meetingId, int roleId);
	//显示会议参与人员信息列表
	List<ParticipantBasicInfo> showMeetingDetail(int meetingId, int roleId);
}
