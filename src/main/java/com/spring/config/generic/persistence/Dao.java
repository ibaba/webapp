package com.spring.config.generic.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Dao<E> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<?> clazz;
	
	public Dao(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	public void persist(E object) {
		sessionFactory.getCurrentSession().persist(object);
	}
	
	@Transactional
	public Object merge(E object) {
		return sessionFactory.getCurrentSession().merge(object);
	}
	
	@Transactional
	public void delete(E object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	
	@Transactional
	public List<?> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}
	
	@Transactional
	public Object findById(int id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	@Transactional
	public Object findByField(String field, String value) {
		return sessionFactory.getCurrentSession().createQuery("from "+clazz.getSimpleName()+" where "+field+" = :data").setParameter("data", value).uniqueResult();
	}
	
}
