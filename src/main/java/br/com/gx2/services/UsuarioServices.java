package br.com.gx2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.UsuarioRepository;
import br.com.gx2.resources.exception.FieldMessage;
import br.com.gx2.services.exceptions.DataIntegrityException;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario find(Integer codigoUsuario) {
		Optional<Usuario> obj = usuarioRepository.findById(codigoUsuario);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Id: " + codigoUsuario + ", Tipo: " + Usuario.class.getName()));
	}

	public Usuario insert(Usuario codigoUsuario) {
		findNomeUsuario(codigoUsuario);
		findEmail(codigoUsuario);
		codigoUsuario.setCodigoUsuario(null);
		return usuarioRepository.save(codigoUsuario);
	}

	public Usuario update(Usuario codigoUsuario) {
		find(codigoUsuario.getCodigoUsuario());
		return usuarioRepository.save(codigoUsuario);
	}

	public void delete(Integer codigoUsuario) {
		find(codigoUsuario);
		try {
			usuarioRepository.deleteById(codigoUsuario);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o usuario " + codigoUsuario);
		}
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}


	public void findEmail(Usuario emailUsuario) {
		Usuario usuario = usuarioRepository.findByEmail(emailUsuario.getEmail());
		if(usuario != null) {
			new FieldMessage("email", "Email já existente");
		}
	}
	
	public void findNomeUsuario(Usuario nomeUsuario) {
		Usuario usuario = usuarioRepository.findByEmail(nomeUsuario.getNomeUsuario());
		if(usuario != null) {
			new FieldMessage("usuario", "Usuário já existente");
		}
	}
}
