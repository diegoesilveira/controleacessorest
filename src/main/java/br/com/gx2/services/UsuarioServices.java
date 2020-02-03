package br.com.gx2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.UsuarioRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario buscarId(Integer id) {
		Optional <Usuario> obj = usuarioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}
