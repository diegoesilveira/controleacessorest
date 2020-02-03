package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.domain.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Usuario, Integer>{

}
