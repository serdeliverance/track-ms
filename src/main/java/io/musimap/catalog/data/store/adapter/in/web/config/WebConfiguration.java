package io.musimap.catalog.data.store.adapter.in.web.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@org.springframework.context.annotation.Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @SuppressWarnings("unused")
    @Bean
    public FilterRegistrationBean buildFormDataForPatchAndPut() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FormContentFilter());
        registration.addUrlPatterns("/*");
        registration.setName("buildFormDataForPatchAndPut");
        registration.setOrder(1);
        return registration;
    }


    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
