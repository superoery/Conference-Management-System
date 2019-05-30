package team.softwarede.confersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		
	}
	
	/**
	 * 设置匹配*.do后缀请求
	 * 不知道能不能不拦截.jsp请求
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        return servletServletRegistrationBean;
	   
	}
	
	

}
