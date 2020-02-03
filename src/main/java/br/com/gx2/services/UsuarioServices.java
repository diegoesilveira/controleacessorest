package br.com.gx2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.UsuarioRepository;
import br.com.gx2.services.exceptions.DataIntegrityException;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(Integer id) {
		Optional <Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setCodigoUsuario(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		find(obj.getCodigoUsuario());
		return usuarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			usuarioRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o usuario " +id);
		}
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
