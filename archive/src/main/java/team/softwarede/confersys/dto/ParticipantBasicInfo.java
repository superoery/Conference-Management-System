package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：在与会者列表中显示与会者名称、状态
 * MeetingDetail.java中引用该类
 */
public class ParticipantBasicInfo {

	private Integer participantId;
	
	private String participantName;
	
	private String participantStatus;
	
	private Integer mtId;

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getParticipantStatus() {
		return participantStatus;
	}

	public void setParticipantStatus(String participantStatus) {
		this.participantStatus = participantStatus;
	}

	public Integer getMtId() {
		return mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

}
