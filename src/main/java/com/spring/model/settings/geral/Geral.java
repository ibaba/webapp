package com.spring.model.settings.geral;

import java.util.Properties;

import com.spring.config.annotation.form_control.Input;

public class Geral extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Input(label = "Titulo")
	private String titulo;
	
	@Input(label = "Autor")
	private String autor;
	
	@Input(label = "E-mail", type = "email")
	private String email;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
