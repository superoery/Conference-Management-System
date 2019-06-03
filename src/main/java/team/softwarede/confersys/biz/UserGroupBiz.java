/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import java.util.List;

import team.softwarede.confersys.dto.UserAndGroup;

/**
 * @author Mity1299
 *
 */
public interface UserGroupBiz {
     
    List<UserAndGroup> searchUAndUGByKeyword(String keyword,String organizerId);
}
