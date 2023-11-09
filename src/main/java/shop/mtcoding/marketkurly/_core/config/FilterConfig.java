package shop.mtcoding.marketkurly._core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.mtcoding.marketkurly._core.filter.ApiJwtAuthorizationFilter;
import shop.mtcoding.marketkurly._core.filter.JwtAuthorizationFilter;

@Configuration
public class FilterConfig {
    @Bean
    FilterRegistrationBean<JwtAuthorizationFilter> jwtFilter() {
        FilterRegistrationBean<JwtAuthorizationFilter> bean = new FilterRegistrationBean<>(
                new JwtAuthorizationFilter());
        System.out.println("/api/users/ 에서 막힘");
        bean.addUrlPatterns("/api/users/*");
        System.out.println("/api/carts/ 에서 막힘");
        bean.addUrlPatterns("/api/carts/*");
        System.out.println("/seller/ 에서 막힘");
        bean.addUrlPatterns("/seller/*");
        System.out.println("/admin/ 에서 막힘");
        bean.addUrlPatterns("/admin/*");
        bean.setOrder(0); // 낮은 번호부터 실행됨
        return bean;
    }

}
