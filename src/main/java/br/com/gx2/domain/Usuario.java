package br.com.gx2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.gx2.domain.enums.StatusUsuario;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoUsuario;
	
	private String nomeUsuario;
	private String usuario;
	private String email;
	private String senha;
	private String status;
	private String token;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Usuario_Permissao",
			joinColumns = @JoinColumn(name  = "codigo_usuario"),
					inverseJoinColumns = @JoinColumn (name = "codigo_permissao"))
	private List<PermissaoUsuario> permissaoUsuario = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(Integer codigoUsuario, String nomeUsuario, String usuario, String email, String senha,
			String status, String token) {

		this.codigoUsuario = codigoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.token = token;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<PermissaoUsuario> getPermissaoUsuario() {
		return permissaoUsuario;
	}

	public void setPermissaoUsuario(List<PermissaoUsuario> permissaoUsuario) {
		this.permissaoUsuario = permissaoUsuario;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigoUsuario == null) {
			if (other.codigoUsuario != null)
				return false;
		} else if (!codigoUsuario.equals(other.codigoUsuario))
			return false;
		return true;
	}

}
