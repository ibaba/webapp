package com.spring.model.settings.geral;

import java.util.Properties;

import com.spring.config.annotation.form.FormSettings;
import com.spring.config.annotation.form_control.Input;

@FormSettings
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
		System.out.println("Geral getTitulo-> "+titulo);
		return titulo;
	}

	public void setTitulo(String titulo) {
		System.out.println("Geral setTitulo-> "+titulo);
		this.titulo = titulo;
	}

	public String getAutor() {
		System.out.println("Geral getAutor-> "+autor);
		return autor;
	}

	public void setAutor(String autor) {
		System.out.println("Geral setAutor-> "+autor);
		this.autor = autor;
	}

	public String getEmail() {
		System.out.println("Geral getEmail-> "+email);
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Geral setEmail-> "+email);
		this.email = email;
	}
	

}
