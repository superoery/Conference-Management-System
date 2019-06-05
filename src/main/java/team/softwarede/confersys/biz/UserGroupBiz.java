/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserBasicInfo;
import team.softwarede.confersys.dto.UserGroupCreate;
import team.softwarede.confersys.dto.UserGroupShow;
import team.softwarede.confersys.entity.UserGroup;

/**
 * @author Mity1299
 *
 */
public interface UserGroupBiz {
     
    List<UserAndGroup> searchUAndUGByKeyword(String keyword,String organizerId);
    
    boolean createUGroup(UserGroupCreate uGroupCreate);
    
    List<UserGroup> showDiyUGroup(String organizerId);
    
    List<UserGroup> showSySUgroup();

}
