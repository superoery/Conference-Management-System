package team.softwarede.confersys.dto;

import java.util.List;

/**
 * 
 * @author wyfca
 * 作用：用户及用户组系统-创建用户组-请求创建新用户组
 */
public class UserGroupCreate {

	private String userGroupName;
	
	private List<String> userIdList;
	
	private String creatorId;

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public List<String> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	
}
