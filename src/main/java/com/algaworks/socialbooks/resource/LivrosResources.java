package com.algaworks.socialbooks.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
@RestController
//apartir dessa URI livros consigo executar qualquer metodo abaixo. 
@RequestMapping("/livros")
public class LivrosResources {
	
	//Autowired verifica se tem alguam implentação para a interface (LivrosRepository)
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping(method = RequestMethod.GET) 
	public List<Livro> Listar(){
		//Como se fosse um select lá na tabela livro. Retorna todos os livros
		return livrosRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro){ //RequestBody : Pega o que esta na requisição e coloca no objeto livro
	    livro = livrosRepository.save(livro);
		
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//Buscar o livro por um determinado ID passado na URI: "/{id}" <- variavel
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar (@PathVariable Long id){ //Pego o valor na variavel acima 
		//Trantando as respostas: ResponseEntity, notação <?> 
		
		Livro livro = livrosRepository.findOne(id);
		
		if (livro == null){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(livro);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deletear(@PathVariable("id") Long id){
		livrosRepository.delete(id);	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
		livro.setId(id); //Confirmando o ID que quero atualizar
		livrosRepository.save(livro);
	}
}

