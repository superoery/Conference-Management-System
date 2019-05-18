/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.biz;

/**
 * User业务逻辑接口
 * @author Mity1299
 *
 */
public interface UserBiz {
    
    public String login(Integer userId,Integer identityId,String passwd);
}
