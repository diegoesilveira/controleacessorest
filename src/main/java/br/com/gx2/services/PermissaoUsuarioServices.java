package br.com.gx2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.repositories.PermissaoUsuarioRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class PermissaoUsuarioServices {
	
	@Autowired
	private PermissaoUsuarioRepository permissaoUsuarioRepository;
	
	public PermissaoUsuario buscarId(Integer id) {
		Optional <PermissaoUsuario> obj = permissaoUsuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PermissaoUsuario.class.getName()));
	}
	

}
