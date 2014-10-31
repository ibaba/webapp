package com.spring.model.usuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.spring.config.annotation.form.Form;
import com.spring.config.annotation.form_control.Input;
import com.spring.config.annotation.form_control.Select;
import com.spring.config.generic.persistence.Model;
import com.spring.model.role.Role;

@Entity
@Form(classe = Usuario.class)
public class Usuario extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Input(label = "Login")
	private String login;
	
	@Input(label = "Senha")
	private String senha;
	
	@Input(label = "Nome")
	private String nome;
	
	@Input(label = "Sobrenome")
	private String sobrenome;
	
	@Input(label = "E-mail")
	private String email;
	
	@ManyToMany
	@JoinTable(name="role_members", joinColumns={@JoinColumn(name="fk_user")}, inverseJoinColumns={@JoinColumn(name="fk_role")})
	@LazyCollection(LazyCollectionOption.FALSE)
	@Select(classe = Role.class, label = "Autoriza&ccedil&otilde;es")
	private List<Role> role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return nome + " " + sobrenome;
	}
	
}
