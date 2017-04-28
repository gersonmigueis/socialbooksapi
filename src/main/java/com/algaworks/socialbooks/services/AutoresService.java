package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.execeptions.AutorExistenteExeception;
import com.algaworks.socialbooks.repository.AutoresRepository;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	

	public Autor salvar(Autor autor){
		//verificando se o autor ja existe
		if(autor.getId() != null){
			
			Autor a = autoresRepository.findOne(autor.getId());
			
			if(a != null){
				
				throw new AutorExistenteExeception("Autor já existe.");
			//Esta sendo tratado a resposta dessa existencia lá no handler.
			}
		}
		return autoresRepository.save(autor);
	}
}
