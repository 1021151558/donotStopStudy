package com.zjut.noStopStudy.config;

import com.zjut.noStopStudy.security.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CrosConfig implements WebMvcConfigurer {

//    @Bean
//    public TokenInterceptor tokenInterceptor() {
//        return new TokenInterceptor();
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        //注册TestInterceptor拦截器
//        List<String> stringList  = new ArrayList<>();
//        stringList.add("/userLogin");
//        stringList.add("/addRegister");
//        stringList.add("/passwordUpdate");
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/userLogin",
                        "/addRegister",
                        "/passwordUpdate");
//                .excludePathPatterns("/donotStopStudy/userLogin")
//                .excludePathPatterns("/donotStopStudy/addRegister")
//                .excludePathPatterns("/donotStopStudy/passwordUpdate");


    }
}