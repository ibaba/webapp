package com.spring.model.settings.geral;

import com.spring.config.annotation.form.FormSettings;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.generic.persistence.Settings;

@FormSettings
public class Geral extends Settings {

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
		return this.getProperty("geral.titulo");
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.getProperty("geral.autor");
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEmail() {
		return this.getProperty("geral.email");
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
