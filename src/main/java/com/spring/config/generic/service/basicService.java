package com.spring.config.generic.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.spring.config.annotation.form_action.Item;
import com.spring.config.annotation.form_action.Menu;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.generic.persistence.Dao;

public class basicService<E> {

	@Autowired
	protected Dao<E> dao;
	
	protected Class<?> clazz;
	
	public basicService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	@PreAuthorize("hasPermission(#user, 'cadastra_'+#this.this.name)")
	public void insert(E object) {
		dao.persist(object);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	@PreAuthorize("hasPermission(#user, 'altera_'+#this.this.name)")
	public E update(E object) {
		return (E) dao.merge(object);
	}
	
	@Transactional
	@PreAuthorize("hasPermission(#user, 'remove_'+#this.this.name)")
	public void remove(E object) {
		dao.delete(object);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public E newObject() throws Exception {
		return (E) clazz.newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public E getObject(Integer id) {
		return (E) dao.findById(id);
	}
	
	@Transactional
	public List<?> lista() {
		return dao.findAll();
	}
	
	public List<String> header() {
		List<String> ret = new ArrayList<String>();
		
		List<Field> lista = Arrays.asList(clazz.getDeclaredFields());
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).isAnnotationPresent(Input.class))
				ret.add(lista.get(i).getName());
		}
		
		return ret;
	}
	
	public List<String> menu(Class<?> controller) {
		List<String> ret = new ArrayList<String>();
		
		List<Method> lista = Arrays.asList(controller.getDeclaredMethods());
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).isAnnotationPresent(Menu.class))
				ret.add(lista.get(i).getName());
		}
		
		return ret;
	}
	
	public List<String> item(Class<?> controller) {
		List<String> ret = new ArrayList<String>();
		
		List<Method> lista = Arrays.asList(controller.getDeclaredMethods());
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).isAnnotationPresent(Item.class))
				ret.add(lista.get(i).getName());
		}
		
		return ret;
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
