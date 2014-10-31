package com.spring.model.permission;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.spring.config.annotation.form_control.Input;

@Entity
public class Permission {

	@Id
	private Integer id;
	
	@Input(label = "Nome")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
