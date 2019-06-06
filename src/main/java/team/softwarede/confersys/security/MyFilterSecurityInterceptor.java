/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

/**
 * @author Mity1299
 *
 */
@Service
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{

    @Autowired
    FilterInvocationSecurityMetadataSource securityMetadataSource;
    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }
    
    public void invoke(FilterInvocation fi) throws IOException,ServletException{
        
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
        
    }
    
    @Override
    public Class<?> getSecureObjectClass() {
        // TODO Auto-generated method stub
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        // TODO Auto-generated method stub
        return this.securityMetadataSource;
    }







    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
