package br.com.gx2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.domain.Usuario;
import br.com.gx2.services.UsuarioServices;

	@RestController
	@RequestMapping(value = "/usuarios")
	public class UsuarioResource {

	@Autowired
	private UsuarioServices usuarioService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = usuarioService.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}

}
