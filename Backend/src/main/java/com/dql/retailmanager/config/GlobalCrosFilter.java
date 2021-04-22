package com.dql.retailmanager.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class GlobalCrosFilter {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许访问的origin请求，即前端服务部署（tomcat）的地址，即设置Access-Control-Allow-Origin
        config.setAllowedOrigins(Arrays.asList("http://localhost:8081","localhost:8081"));
        // 可访问的header
        config.addAllowedHeader("*");
        // 允许访问的请求方法类型，此处禁用PUT、DELETE之类的有安全风险的方法访问后台可避免那些方法带来的漏洞风险
        config.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
