package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.gx2.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
	
	@Transactional(readOnly=true)
	Usuario findByNomeUsuario(String nomeUsuario);
}
