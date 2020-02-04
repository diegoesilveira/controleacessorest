package br.com.gx2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gx2.domain.Usuario;
import br.com.gx2.services.UsuarioServices;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServices usuarioService;

	@RequestMapping(value = "/{codigoUsuario}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer codigoUsuario) {
		Usuario usuario = usuarioService.find(codigoUsuario);
		return ResponseEntity.ok().body(usuario);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario usuario) {
		usuario = usuarioService.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigoUsuario}")
				.buildAndExpand(usuario.getCodigoUsuario()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{codigoUsuario}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Integer codigoUsuario) {
		usuario.setCodigoUsuario(codigoUsuario);
		usuario = usuarioService.update(usuario);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{codigoUsuario}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codigoUsuario) {
		usuarioService.delete(codigoUsuario);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
