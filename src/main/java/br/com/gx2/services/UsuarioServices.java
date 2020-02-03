package br.com.gx2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.UsuarioRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscarId(Integer id) {
		Optional <Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setCodigoUsuario(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		return usuarioRepository.save(obj);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
