package team.softwarede.confersys.dto;

import team.softwarede.confersys.entity.Role;

public class BasicSession {

	private String userId;
	
	private String userName;
	
	private Role role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
