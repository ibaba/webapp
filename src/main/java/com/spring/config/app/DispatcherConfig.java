package com.spring.config.app;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import(WebAppConfig.class)
public class DispatcherConfig {
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
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
