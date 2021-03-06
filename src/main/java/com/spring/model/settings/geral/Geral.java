package com.spring.model.settings.geral;

import org.springframework.beans.factory.annotation.Value;

import com.spring.config.annotation.form.FormSettings;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.annotation.settings.Property;
import com.spring.config.generic.persistence.Settings;

@FormSettings
public class Geral extends Settings {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Input(label = "Titulo")
	@Property(key = "geral.titulo")
	@Value("${geral.titulo}")
	private String titulo;
	
	@Input(label = "Autor")
	@Property(key = "geral.autor")
	@Value("${geral.autor}")
	private String autor;
	
	@Input(label = "E-mail", type = "email")
	@Property(key = "geral.email")
	@Value("${geral.email}")
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

	@Override
	public String toString() {
		return "{"+titulo+", "+autor+", "+email+"}";
	}
	

}
