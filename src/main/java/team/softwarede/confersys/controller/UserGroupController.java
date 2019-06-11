package team.softwarede.confersys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.dto.UserGroupCreate;
import team.softwarede.confersys.entity.UserGroup;
import team.softwarede.confersys.vo.SelectedUserList;

@Controller
@RequestMapping("/userGroup")
public class UserGroupController {

	@Autowired
	UserGroupBiz userGroupBiz;

	@RequestMapping("/showUG.do")
	public String showUG(ModelMap map, HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession", userSession);

		List<UserGroup> myUGList = userGroupBiz.showDiyUGroup(userSession.getUserId());
		map.addAttribute("myUGList", myUGList);

		List<UserGroup> sysUGList = userGroupBiz.showSySUgroup();
		map.addAttribute("sysUGList", sysUGList);

		return "ugroup";
	}

	@RequestMapping(value = "/deleteUG.do", params = { "deleteUGId" })
	public String showMember(ModelMap map, HttpSession session, @ModelAttribute("deleteUGId") int deleteUGId) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession", userSession);

		if (userGroupBiz.deleteUGroup(deleteUGId)) {
			map.addAttribute("deleteMsg", "您已成功删除该用户组！");
			return "ugroup_deleteMsg";
		} else {
			map.addAttribute("deleteMsg", "删除用户组失败！");
			return "ugroup_deleteMsg";
		}
	}
	
	@RequestMapping("/createUG.do")
	public String createNewUG(ModelMap map, 
			HttpSession session, 
			@ModelAttribute("addUserId") String addUserId,
			@ModelAttribute("selectedUserList") SelectedUserList selectedUserList) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession", userSession);
		
		// attributes.addFlashAttribute将redirect前的参数放进map里
		map.addAttribute("selectedUserList", selectedUserList);
		
		return "ugroup_create";
	}
	
	@RequestMapping("/addUserId.do")
	public String addUserId(ModelMap map, 
			RedirectAttributes attributes, 
			@ModelAttribute("addUserId") String addUserId,
			@ModelAttribute("selectedUserList") SelectedUserList selectedUserList) {
		List<String> newList = new ArrayList<String>();

		if (selectedUserList != null && selectedUserList.getSelectedUserList()!=null) {
			if (selectedUserList.getSelectedUserList().size() != 0) {
				for (String user : selectedUserList.getSelectedUserList()) {
					newList.add(user);
				}
			}
		}
		newList.add(addUserId);
		
		SelectedUserList newSelectedUserList = new SelectedUserList();
		newSelectedUserList.setSelectedUserList(newList);
		attributes.addFlashAttribute("selectedUserList", newSelectedUserList);
		
		return "redirect:/userGroup/createUG.do";
	}
	
	@RequestMapping("/submitUG.do")
	public String submitUG(ModelMap map,
			@ModelAttribute("selectedUserList") SelectedUserList selectedUserList,
			@ModelAttribute("userGroupName") String userGroupName,
			HttpSession session) {
		BasicSession userSession = (BasicSession) session.getAttribute("userSession");
		map.addAttribute("userSession", userSession);
		
		UserGroupCreate userGroupCreate = new UserGroupCreate();
		userGroupCreate.setCreatorId(userSession.getUserId());
		userGroupCreate.setUserGroupName(userGroupName);
		userGroupCreate.setUserIdList(selectedUserList.getSelectedUserList());
		
//		System.out.println("submitUG: "+userGroupName);
//		if (selectedUserList != null && selectedUserList.getSelectedUserList()!=null) {
//			if (selectedUserList.getSelectedUserList().size() != 0) {
//				for (String userId : selectedUserList.getSelectedUserList()) {
//					System.out.println("submitUG: "+userId);
//				}
//			}else {
//				System.out.println("submitUG: selectedUserList.getSelectedUserList().size()==0");
//			}
//		}else {
//			System.out.println("submitUG: selectedUserList == null or selectedUserList.getSelectedUserList()==null");
//		}
		
		if(userGroupBiz.createUGroup(userGroupCreate)) {
			map.addAttribute("createMsg", "您已成功创建该用户组");
		}else {
			map.addAttribute("createMsg", "创建用户组失败");
		}
		
		return "ugroup_create_submitMsg";
	}
}
