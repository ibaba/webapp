package com.spring.config.app;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
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
    static PropertySourcesPlaceholderConfigurer property() throws Exception {
    	PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
    	
    	String filename = System.getProperty("user.home")+File.separator+".webapp"+File.separator+"webapp.preferences";
    	File file = new File( filename );
    	if(file.exists())
    		propertyConfigurer.setLocation( new FileSystemResource( filename ) );
    	else {
    		if(file.mkdir()) {
        		FileOutputStream fos = new FileOutputStream( filename );
        		fos.close();
        		propertyConfigurer.setLocation( new FileSystemResource( filename ) );
    		}
    	}
    	
    	return propertyConfigurer;
    }
	
}
