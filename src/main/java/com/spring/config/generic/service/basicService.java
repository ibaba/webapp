package com.spring.config.generic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.spring.config.generic.persistence.Dao;

public class basicService<E> {

	@Autowired
	protected Dao<E> dao;
	
	protected Class<?> clazz;
	
	public basicService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@PreAuthorize("hasPermission(#user, 'cadastra_'+#this.this.name)")
	public void insert(E object) {
		dao.persist(object);
	}
	
	@SuppressWarnings("unchecked")
	@PreAuthorize("hasPermission(#user, 'altera_'+#this.this.name)")
	public E update(E object) {
		return (E) dao.merge(object);
	}
	
	@PreAuthorize("hasPermission(#user, 'remove_'+#this.this.name)")
	public void remove(E object) {
		dao.delete(object);
	}
	
	@SuppressWarnings("unchecked")
	public E newObject() throws Exception {
		return (E) clazz.newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public E getObject(Integer id) {
		return (E) dao.findById(id);
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
	public List<?> lista() {
		return dao.findAll();
	}
	
}
