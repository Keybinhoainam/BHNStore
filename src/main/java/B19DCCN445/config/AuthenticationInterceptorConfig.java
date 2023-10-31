package B19DCCN445.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import B19DCCN445.interceptor.AdminAuthenticationInterceptor;
import B19DCCN445.interceptor.CustomerAuthenticationInterceptor;



@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer{
	@Autowired
	AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	@Autowired
	CustomerAuthenticationInterceptor customerAuthenticationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationInterceptor)
			.addPathPatterns("/admin/**");
		registry.addInterceptor(customerAuthenticationInterceptor).addPathPatterns("/customer/cart/**");
	}

}
