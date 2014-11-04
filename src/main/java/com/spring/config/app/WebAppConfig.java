package com.spring.config.app;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(value="com.spring")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
    @Bean
    public PropertySourcesPlaceholderConfigurer property() throws Exception {
    	PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
    	
    	Properties props = new Properties();
    	FileInputStream fos = new FileInputStream(System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences");
    	props.load(fos);
    	propertyConfigurer.setProperties(props);
    	
    	return propertyConfigurer;
    }
	
}
