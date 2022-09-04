package board.myProj;

import board.myProj.domain.member.login.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/**").order(1).excludePathPatterns("/css/**","/*.ico","/","/member/save","/login","/logout","/member/{loginId}");
    }
}
