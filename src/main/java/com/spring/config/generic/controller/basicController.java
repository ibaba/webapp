package com.spring.config.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.config.generic.service.basicService;

public class basicController<E> {

	@Autowired
	protected basicService<E> serv;
	
	protected Class<?> clazz;
	
	public basicController(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(value = "index")
	@PreAuthorize("hasPermission(#user, 'listagem_'+#this.this.name)")
	public String index(Model model) {
		model.addAttribute("classe", getName());
		model.addAttribute("header", serv.header());
		return "private/index";
	}
	
	@RequestMapping(value = "cadastrar")
	@PreAuthorize("hasPermission(#user, 'cadastra_'+#this.this.name)")
	public String cadastro(Model model) throws Exception {
		model.addAttribute("command", serv.newObject());
		return "private/form";
	}
	
	@RequestMapping(value = "alterar/{id}")
	@PreAuthorize("hasPermission(#user, 'altera_'+#this.this.name)")
	public String alteracao(Model model, @PathVariable("id") String id) {
		model.addAttribute("command", serv.getObject(Integer.valueOf(id)));
		return "private/form";
	}
	
	@RequestMapping(value = "remover/{id}")
	@PreAuthorize("hasPermission(#user, 'remove_'+#this.this.name)")
	public String remocao(Model model, @PathVariable("id") String id) {
		model.addAttribute("command", serv.getObject(Integer.valueOf(id)));
		return "private/form";
	}
	
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	public void cadastro(@ModelAttribute("object") E object) {
		serv.insert(object);
	}
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public void alteracao(@ModelAttribute("object") E object) {
		serv.update(object);
	}
	
	@RequestMapping(value = "delete", method=RequestMethod.POST)
	public void remocao(@ModelAttribute("object") E object) {
		serv.remove(object);
	}
	
	@RequestMapping(value = "lista.json")
	@ResponseBody
	public String select() throws JsonProcessingException {
		String json = "";
		
		ObjectMapper mapper = new ObjectMapper();		
		json = mapper.writeValueAsString(serv.lista());
		
		return json;
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
