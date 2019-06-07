package team.softwarede.confersys.dto;

import java.util.List;

import team.softwarede.confersys.entity.User;

/**
 * 
 * @author wyfca
 * 作用：用户及用户组系统-创建用户组-返回用户组列表
 *
 */
public class UserGroupShow {

	private Integer userGroupId;
	
	private String userGroupName;
	
	private Integer creatorId;

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}


	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
}
