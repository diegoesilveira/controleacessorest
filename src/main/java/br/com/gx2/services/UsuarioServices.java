package br.com.gx2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.diego.domain.Categoria;
import br.com.diego.services.exceptions.ObjectNotFoundException;
import br.com.gx2.domain.Usuario;
import br.com.gx2.repositories.UsuarioRepository;

public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario buscarId(Integer id) {
		Optional <Usuario> obj = usuarioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}
