package com.spring.config.generic.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.config.generic.service.settingsService;

public class settingsController<E extends Properties> {
	
	@Autowired
	private settingsService<E> serv;

	protected Class<?> clazz;
	
	public settingsController(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public void insert(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		serv.create_properties(object);
	}
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public void update(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		serv.save_properties(object);
	}
	
	@RequestMapping(value = "delete", method=RequestMethod.POST)
	public void delete(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		serv.delete_properties(object);
	}
	
	@RequestMapping(value = "load/{key}")
	@ResponseBody
	public String load_property(Model model, @PathVariable("key") String key) throws Exception {
		return serv.read_property(key);
	}
	
	@RequestMapping(value = "save/{key}", method=RequestMethod.GET)
	@ResponseBody
	public void save_property(Model model, @PathVariable("key") String key, @RequestParam("value") String value) throws Exception {
		serv.save_property(key, value);
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
