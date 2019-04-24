package com.example.urlparser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/webjars/**")
            .addResourceLocations("/webjars/");

//        registry
//            .addResourceHandler("/static/**")
//            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
