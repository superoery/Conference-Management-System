package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.MeetingDetail;
import team.softwarede.confersys.dto.MeetingDetailWithoutParticipantsList;
import team.softwarede.confersys.dto.ParticipantBasicInfo;

/**
 * 
 * @author SunRonglin
 *
 */
public interface ShowMeetingDetailBiz {
	//显示会议参与人员信息列表
	List<ParticipantBasicInfo> showMeetingDetail(int meetingId);
}
