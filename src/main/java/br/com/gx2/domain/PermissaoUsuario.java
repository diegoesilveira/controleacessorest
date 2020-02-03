package br.com.gx2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PermissaoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoPermissao;
	private String permissao;

	@JsonManagedReference
	@ManyToMany(mappedBy = "permissaoUsuario")
	private List<Usuario> usuario = new ArrayList<>();

	public PermissaoUsuario() {
	}

	public PermissaoUsuario(Integer codigoPermissao, String permissao) {
		this.codigoPermissao = codigoPermissao;
		this.permissao = permissao;
	}

	public Integer getCodigoPermissao() {
		return codigoPermissao;
	}

	public void setCodigoPermissao(Integer codigoPermissao) {
		this.codigoPermissao = codigoPermissao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPermissao == null) ? 0 : codigoPermissao.hashCode());
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
		PermissaoUsuario other = (PermissaoUsuario) obj;
		if (codigoPermissao == null) {
			if (other.codigoPermissao != null)
				return false;
		} else if (!codigoPermissao.equals(other.codigoPermissao))
			return false;
		return true;
	}

}
