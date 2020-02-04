package br.com.gx2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.repositories.PermissaoUsuarioRepository;
import br.com.gx2.services.exceptions.DataIntegrityException;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoUsuarioServices {

	@Autowired
	private PermissaoUsuarioRepository permissaoUsuarioRepository;

	public PermissaoUsuario find(Integer codigoPermissao) {
		Optional<PermissaoUsuario> permissaoUsuario = permissaoUsuarioRepository.findById(codigoPermissao);
		return permissaoUsuario.orElseThrow(() -> new ObjectNotFoundException(
				"Permissão não encontrado! Id: " + codigoPermissao + ", Tipo: " + PermissaoUsuario.class.getName()));
	}

	public PermissaoUsuario insert(PermissaoUsuario codigoPermissao) {
		codigoPermissao.setCodigoPermissao(null);
		return permissaoUsuarioRepository.save(codigoPermissao);
	}

	public PermissaoUsuario update(PermissaoUsuario codigoPermissao) {
		return permissaoUsuarioRepository.save(codigoPermissao);
	}

	public void delete(Integer codigoPermissao) {
		find(codigoPermissao);
		try {
			permissaoUsuarioRepository.deleteById(codigoPermissao);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não foi possível excluir a permissão.");
		}

	}

	public List<PermissaoUsuario> findAll() {
		return permissaoUsuarioRepository.findAll();
	}

}
