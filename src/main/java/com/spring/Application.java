package com.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.config.annotation.form.Form;
import com.spring.config.annotation.form.FormPublic;
import com.spring.config.annotation.form.FormSettings;

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
	public String admin(Model model) throws Exception {
		model.addAttribute("menu", lista_private());
		return "private/admin";
	}
	
	@RequestMapping(value = "/")
	public String index(Model model) throws Exception {
		model.addAttribute("menu", lista_public());
		return "public/index";
	}
	
	@RequestMapping(value = "/profile")
	public String profile(Model model) {
		return "private/profile";
	}
	
	@RequestMapping(value = "/settings")
	public String settings(Model model) throws Exception {
		model.addAttribute("settings", lista_settings());
		return "private/settings";
	}
	
	private List<Class<?>> lista_private() throws Exception {
		List<Class<?>> lista = new ArrayList<Class<?>>();
		
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(Form.class));
		for (BeanDefinition bd : scanner.findCandidateComponents("com.spring.model")) {
			lista.add(Class.forName(bd.getBeanClassName()));
		}
		
		return lista;
	}
	
	private List<Class<?>> lista_public() throws Exception {
		List<Class<?>> lista = new ArrayList<Class<?>>();
		
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(FormPublic.class));
		for (BeanDefinition bd : scanner.findCandidateComponents("com.spring.model")) {
			lista.add(Class.forName(bd.getBeanClassName()));
		}
		
		return lista;
	}
	
	private List<Class<?>> lista_settings() throws Exception {
		List<Class<?>> lista = new ArrayList<Class<?>>();
		
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(FormSettings.class));
		for (BeanDefinition bd : scanner.findCandidateComponents("com.spring.model")) {
			lista.add(Class.forName(bd.getBeanClassName()));
		}
		
		return lista;
	}
	
}
