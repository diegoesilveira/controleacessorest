package br.com.gx2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.PermissaoUsuarioRepository;
import br.com.gx2.services.exceptions.DataIntegrityException;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoUsuarioServices {
	
	@Autowired
	private PermissaoUsuarioRepository permissaoUsuarioRepository;
	
	public PermissaoUsuario find(Integer id) {
		Optional <PermissaoUsuario> obj = permissaoUsuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PermissaoUsuario.class.getName()));
	}
	
	public PermissaoUsuario insert(PermissaoUsuario obj) {
		obj.setCodigoPermissao(null);
		return permissaoUsuarioRepository.save(obj);
	}
	
	public PermissaoUsuario update(PermissaoUsuario obj) {
		return permissaoUsuarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			permissaoUsuarioRepository.deleteById(id);
		}
		catch(DataIntegrityException e) {
			throw new DataIntegrityException("Não foi possível excluir a permissão.");
		}
		
	}
	
	
	
	public List<PermissaoUsuario> findAll() {
		return permissaoUsuarioRepository.findAll();
	}

}
