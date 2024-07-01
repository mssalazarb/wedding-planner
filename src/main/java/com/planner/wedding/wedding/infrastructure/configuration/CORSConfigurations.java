package com.planner.wedding.wedding.infrastructure.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.planner.wedding.wedding.infrastructure.filters.SimpleCORSFilter;

@Configuration
public class CORSConfigurations {
    @Bean
    public FilterRegistrationBean<SimpleCORSFilter> corsFilter() {
        FilterRegistrationBean<SimpleCORSFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SimpleCORSFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
