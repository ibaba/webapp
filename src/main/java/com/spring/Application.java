package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(value="com.spring")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
	@RequestMapping(value = "/signin")
	public String signin(Model model) {
		return "acesso/signin";
	}
	
	@RequestMapping(value = "/admin")
	@PreAuthorize("hasPermission(#user, 'admin')")
	public String admin(Model model) {
		return "private/admin";
	}
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		return "public/index";
	}
	
}
