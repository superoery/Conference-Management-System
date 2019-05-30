package team.softwarede.confersys.dto;

/**
 * 
 * @author wyfca
 * 作用：在用户组相关操作时显示用户基本信息
 * UserGroupShow.java中引用该类
 */
public class UserBasicInfo {

	private Integer userId;
	
	private String userName;
	
	private String identity;
	
	private String role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
