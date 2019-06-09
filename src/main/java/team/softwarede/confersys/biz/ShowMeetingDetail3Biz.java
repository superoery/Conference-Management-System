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
public interface ShowMeetingDetail3Biz {
	//普通用户返回的会议详情
	MeetingDetailWithoutParticipantsList showMeetingDetail3(int meetingId);
}
