package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：会议室预约系统-读取会议室申请结果-返回一般通知详情
 * 
 */
public class NotificationDetail {
	
	private Integer noteId;

	private String noteType;
	
	private String noteDetail;
	
	private String noteStatus;
	
	private String noteReferMtName;
	
	private Integer noteReferMtId;

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteType() {
		return noteType;
	}

	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	public String getNoteDetail() {
		return noteDetail;
	}

	public void setNoteDetail(String noteDetail) {
		this.noteDetail = noteDetail;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public String getNoteReferMtName() {
		return noteReferMtName;
	}

	public void setNoteReferMtName(String noteReferMtName) {
		this.noteReferMtName = noteReferMtName;
	}

	public Integer getNoteReferMtId() {
		return noteReferMtId;
	}

	public void setNoteReferMtId(Integer noteReferMtId) {
		this.noteReferMtId = noteReferMtId;
	}
}
