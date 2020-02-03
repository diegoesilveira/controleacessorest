package br.com.gx2.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gx2.domain.PermissaoUsuario;
import br.com.gx2.domain.Usuario;
import br.com.gx2.services.PermissaoUsuarioServices;

@RestController
	@RequestMapping(value = "/permissaousuario")
	public class PermissaoUsuarioResource {
		
		@Autowired
		private PermissaoUsuarioServices permissaoUsuarioService;
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<PermissaoUsuario> find(@PathVariable Integer id) {
			PermissaoUsuario obj = permissaoUsuarioService.buscarId(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody PermissaoUsuario obj){
			obj = permissaoUsuarioService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getCodigoPermissao()).toUri();
				return ResponseEntity.created(uri).build();
		}

}
