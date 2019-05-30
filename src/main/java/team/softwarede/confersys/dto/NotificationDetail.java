package team.softwarede.confersys.dto;

public class NotificationDetail {
	
	private String noteId;

	private String noteType;
	
	private String noteDetail;
	
	private String noteStatus;
	
	private String noteSenderId;
	
	private String noteSenderName;
	
	private String noteReferMtName;
	
	private Integer noteReferMtId;

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
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

	public String getNoteSenderId() {
		return noteSenderId;
	}

	public void setNoteSenderId(String noteSenderId) {
		this.noteSenderId = noteSenderId;
	}

	public String getNoteSenderName() {
		return noteSenderName;
	}

	public void setNoteSenderName(String noteSenderName) {
		this.noteSenderName = noteSenderName;
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
