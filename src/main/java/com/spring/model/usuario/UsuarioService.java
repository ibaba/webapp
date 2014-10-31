package com.spring.model.usuario;

import org.springframework.stereotype.Service;

import com.spring.config.generic.service.basicService;

@Service
public class UsuarioService extends basicService<Usuario> {

	public UsuarioService() {
		super(Usuario.class);
	}

}
