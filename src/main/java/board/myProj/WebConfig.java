package board.myProj;

import board.myProj.web.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor()).addPathPatterns("/member/**","/board/**").order(1);
    }

//    @Override
//    public Validator getValidator() {
//        return new MemberValidation();
//    }

}
