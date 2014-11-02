package com.spring.model.role;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.spring.config.annotation.form_control.Input;
import com.spring.config.annotation.form_control.Select;
import com.spring.config.generic.persistence.Model;
import com.spring.model.permission.Permission;

@Entity
public class Role extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Input(label = "Nome")
	private String nome;
	
	@ManyToMany
	@JoinTable(name="role_permissions", joinColumns={@JoinColumn(name="fk_role")}, inverseJoinColumns={@JoinColumn(name="fk_permission")})
	@LazyCollection(LazyCollectionOption.FALSE)
	@Select(classe = Permission.class, label = "Permiss&otilde;es")
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

	@Override
	public String toString() {
		return nome;
	}
	
}
