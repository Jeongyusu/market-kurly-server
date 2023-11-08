// package shop.mtcoding.marketkurly._core.config;

// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import shop.mtcoding.marketkurly._core.filter.ApiJwtAuthorizationFilter;
// import shop.mtcoding.marketkurly._core.filter.JwtAuthorizationFilter;

// @Configuration
// public class FilterConfig {
// @Bean
// FilterRegistrationBean<JwtAuthorizationFilter> jwtFilter() {
// FilterRegistrationBean<JwtAuthorizationFilter> bean = new
// FilterRegistrationBean<>(
// new JwtAuthorizationFilter());
// bean.addUrlPatterns("/seller/*");
// System.out.println("/seller/ 에서 막힘");
// bean.addUrlPatterns("/admin/*");
// System.out.println("/admin/ 에서 막힘");
// bean.setOrder(0); // 낮은 번호부터 실행됨
// return bean;
// }

// @Bean
// FilterRegistrationBean<ApiJwtAuthorizationFilter> apiJwtFilter() {
// FilterRegistrationBean<ApiJwtAuthorizationFilter> bean = new
// FilterRegistrationBean<>(
// new ApiJwtAuthorizationFilter());
// bean.addUrlPatterns("/api/*");
// bean.setOrder(0); // 낮은 번호부터 실행됨
// return bean;
// }
// }
