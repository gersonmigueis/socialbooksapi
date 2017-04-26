package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Comentario;
//repositorio referente a classe comentario, para podermos manipula-la
public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

	
}
