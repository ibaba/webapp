package com.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Order(value=1)
public class WebAppInitializer implements WebApplicationInitializer {

	@SuppressWarnings("resource")
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	      // Create the 'root' Spring application context
	      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	      rootContext.register(WebAppConfig.class);

	      // Create the dispatcher servlet's Spring application context
	      AnnotationConfigWebApplicationContext jspContext = new AnnotationConfigWebApplicationContext();
	      jspContext.register(DispatcherConfig.class);

	      // Register and map the dispatcher servlet
	      ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(jspContext));
	      dispatcher.setLoadOnStartup(1);
	      dispatcher.addMapping("/");
	}

}
