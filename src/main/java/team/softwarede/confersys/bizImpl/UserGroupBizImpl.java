/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.bizImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.softwarede.confersys.biz.UserGroupBiz;
import team.softwarede.confersys.dto.UGroupSearch;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserGroupCreate;
import team.softwarede.confersys.dto.UserGroupShow;
import team.softwarede.confersys.dto.UserSearch;
import team.softwarede.confersys.dtomapper.UserAndGroupMapper;
import team.softwarede.confersys.entity.BelongsToKey;
import team.softwarede.confersys.entity.UserGroup;
import team.softwarede.confersys.enums.EnumUserAndGroup;
import team.softwarede.confersys.mapper.BelongsToMapper;
import team.softwarede.confersys.mapper.UserGroupMapper;

/**
 * @author Mity1299
 *
 */
@Service("userGroupBiz")
public class UserGroupBizImpl implements UserGroupBiz {

    @Autowired
    UserAndGroupMapper userAndGroupMapper; 
    @Autowired
    UserGroupMapper userGroupMapper;
    @Autowired
    BelongsToMapper belongsToMapper;
    
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

    @Transactional
    @Override
    public boolean createUGroup(UserGroupCreate uGroupCreate) {
        // TODO Auto-generated method stub
        
        UserGroup uGroup = new UserGroup();
        uGroup.setName(uGroupCreate.getUserGroupName());
        uGroup.setUserId(uGroupCreate.getCreatorId());
        userGroupMapper.insertSelective(uGroup);
        
        Integer uGroupId = uGroup.getId();
        
        for(String userId : uGroupCreate.getUserIdList()) {
            BelongsToKey belongKey = new BelongsToKey();
            belongKey.setId(uGroupId);
            belongKey.setUserId(userId);
            belongsToMapper.insertSelective(belongKey);
        }

        return true;
    }

}
