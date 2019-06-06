/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import team.softwarede.confersys.biz.ShowMeetingMainPageBiz;
import team.softwarede.confersys.dto.BasicSession;
import team.softwarede.confersys.entity.Permission;
import team.softwarede.confersys.mapper.PermissionMapper;
import team.softwarede.confersys.mapper.UserMapper;

/**
 * @author Mity1299
 *
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    ShowMeetingMainPageBiz showMeetingMainPageBiz; 
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    UserMapper userMapper;
    
    
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        BasicSession basicSession = showMeetingMainPageBiz.getBasicSession(userId);
        team.softwarede.confersys.entity.User user = userMapper.selectByPrimaryKey(userId);
        
        if(basicSession != null) {
            List<Permission> permissions = permissionMapper.selectByRoleId(basicSession.getRole().getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            
            for(Permission permission : permissions) {
                if(permission != null && permission.getName()!=null) {
                    
                  //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                    
                }
                
            }
            
            return new User(user.getName(),user.getPassword(),grantedAuthorities);
            
            
        }
        
        return null;
    }

}
