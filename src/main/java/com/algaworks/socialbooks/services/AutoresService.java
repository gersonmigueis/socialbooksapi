package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.execeptions.AutorExistenteException;
import com.algaworks.socialbooks.execeptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.repository.AutoresRepository;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	

	public Autor salvar(Autor autor){
		
		if(autor.getId() != null){
			
			Autor a = autoresRepository.findOne(autor.getId());
			
			if(a != null){
				
				throw new AutorExistenteException("O Autor já existe.");
			//Esta sendo tratado a resposta dessa existencia lá no handler.
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id){
		Autor autor = autoresRepository.findOne(id);
		
		if(autor == null){
			throw new AutorNaoEncontradoException("O Autor não pode ser encontrado.");
		}
		
		return autor;
	}
}

 	
