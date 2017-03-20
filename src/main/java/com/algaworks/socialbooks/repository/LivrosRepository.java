package com.algaworks.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Livro;
//interface para fazer as operações no banco de dados(select, insert, update)
public interface LivrosRepository extends JpaRepository<Livro, Long> {
	
	

}
