package com.chatweb;

import com.chatweb.core.interceptor.UserAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件路径映射类
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${web.upload}")
    private String webUpload;


    private UserAuthenticationInterceptor securityInterceptor;

    @Autowired
    public WebAppConfig(UserAuthenticationInterceptor securityInterceptor) {
        super();
        this.securityInterceptor = securityInterceptor;
    }

    @Resource(name = "thymeleafViewResolver")
    private ThymeleafViewResolver thymeleafViewResolver;

    @Value("${webtap.cdn}")
    private String cdn = "";


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        if (thymeleafViewResolver != null) {
            Map<String, Object> vars = new HashMap<>(1);
            vars.put("cdn", cdn);
            thymeleafViewResolver.setStaticVariables(vars);
        }
        super.configureViewResolvers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后台登录拦截器拦截路径
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/adminlogin/**");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        return factory.createMultipartConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/upload/**").addResourceLocations("file:"+webUpload);
        //  super.addResourceHandlers(registry);
    }

}
