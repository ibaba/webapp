package com.spring.model.usuario;

import org.springframework.stereotype.Repository;

import com.spring.config.generic.persistence.Dao;

@Repository
public class UsuarioDao extends Dao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}
	
}
