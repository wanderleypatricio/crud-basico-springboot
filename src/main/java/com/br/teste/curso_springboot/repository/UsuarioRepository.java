package com.br.teste.curso_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.teste.curso_springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value="select u from Usuario u where u.nome like %?1%")
	List<Usuario> buscaPorNome(String nome);
}
