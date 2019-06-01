/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.UGroupSearch;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserSearch;
import team.softwarede.confersys.dtomapper.UserAndGroupMapper;
import team.softwarede.confersys.enums.EnumUserAndGroup;

/**
 * @author Mity1299
 *
 */
@Service("userGroupBiz")
public class UserGroupBizImpl implements UserGroupBiz {

    @Autowired
    UserAndGroupMapper userAndGroupMapper; 
    
    @Override
    public List<UserAndGroup> searchUAndUGByKeyword(String keyword,String organizerId) {
        // TODO Auto-generated method stub
        
        List<UserAndGroup> totalList = new ArrayList<UserAndGroup>();
        
        List<UserSearch> userList = userAndGroupMapper.selectUserFuzzyBykeyword(keyword);
        List<UGroupSearch> uGroupList = 
                userAndGroupMapper.selectGroupFuzzyBykeyword(organizerId, keyword);
        
        for(UserSearch us : userList) {
            UserAndGroup ug = new UserAndGroup();
            ug.setId(us.getId());
            ug.setName(us.getName());
            ug.setType(EnumUserAndGroup.USER.ordinal());
            totalList.add(ug);
        }
        
        for(UGroupSearch ugs : uGroupList) {
            UserAndGroup ug = new UserAndGroup();
            ug.setId(ugs.getuGroupId().toString());
            ug.setName(ugs.getName());
            ug.setType(EnumUserAndGroup.UGROUP.ordinal());
            totalList.add(ug);
        }

        return totalList;
    }

}
