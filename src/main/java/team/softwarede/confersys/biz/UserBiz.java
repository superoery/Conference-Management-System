/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

import team.softwarede.confersys.entity.Role;

/**
 * @author Mity1299
 *
 */
public interface UserBiz {

    String login(String userId,Integer identityId,String passwd);
    

}
