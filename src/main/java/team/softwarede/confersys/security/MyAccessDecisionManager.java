/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * @author Mity1299
 *
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    
    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        // TODO Auto-generated method stub
        
        if(configAttributes == null || configAttributes.size()<=0 ) {
            return;
        }
        ConfigAttribute c;
        String needRole;
        //configAttributes 是判定用户请求的url是否在权限表中的结果
        for(Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext();) {
            c = iter.next();
            needRole = c.getAttribute();
            
            //authentication存放了当前登录用户所拥有的权限
            for(GrantedAuthority ga : authentication.getAuthorities()) {
                if(needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
            
        }

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return true;
    }

}
