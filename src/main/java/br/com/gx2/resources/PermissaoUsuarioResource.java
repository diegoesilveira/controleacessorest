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
		
		@RequestMapping(value = "/{codigoPermissao}", method = RequestMethod.GET)
		public ResponseEntity<PermissaoUsuario> find(@PathVariable Integer codigoPermissao) {
			PermissaoUsuario permissaoUsuario = permissaoUsuarioService.find(codigoPermissao);
			return ResponseEntity.ok().body(permissaoUsuario);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@RequestBody PermissaoUsuario permissaoUsuario){
			permissaoUsuario = permissaoUsuarioService.insert(permissaoUsuario);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{codigoPermissao}").buildAndExpand(permissaoUsuario.getCodigoPermissao()).toUri();
				return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value = "/{codigoPermissao}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@RequestBody PermissaoUsuario permissaoUsuario, @PathVariable Integer codigoPermissao){
			permissaoUsuario.setCodigoPermissao(codigoPermissao);
			permissaoUsuario = permissaoUsuarioService.update(permissaoUsuario);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value="/{codigoPermissao}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer codigoPermissao) {
			permissaoUsuarioService.delete(codigoPermissao);
			return ResponseEntity.noContent().build();
		}
		
		
		
		

}
