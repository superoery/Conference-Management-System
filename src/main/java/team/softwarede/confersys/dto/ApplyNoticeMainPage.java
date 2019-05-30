package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：登陆系统-显示主界面-返回会议室预约列表（管理员主界面）
 */
public class ApplyNoticeMainPage {

	private Integer applyId;
	
	private String applicantName;
	
	private String mtTopic;
	
	private String applyTime;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	
	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getMtTopic() {
		return mtTopic;
	}

	public void setMtTopic(String mtTopic) {
		this.mtTopic = mtTopic;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	
}
