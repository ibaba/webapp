package com.spring.model.role;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.spring.model.permission.Permission;

@Entity
public class Role {

	@Id
	private Integer id;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="role_permissions", joinColumns={@JoinColumn(name="fk_role")}, inverseJoinColumns={@JoinColumn(name="fk_permission")})
	private List<Permission> permission;

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

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	
}
