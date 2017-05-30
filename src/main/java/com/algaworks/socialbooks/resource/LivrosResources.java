package com.algaworks.socialbooks.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.services.LivrosService;
@RestController
//apartir dessa URI livros consigo executar qualquer metodo abaixo. 
@RequestMapping("/livros")
public class LivrosResources {
	
	//Autowired verifica se tem alguma implentação para a interface (LivrosRepository)
	@Autowired
	private LivrosService livrosService;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Livro>> Listar(){
		
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Livro livro){ 
		//RequestBody : Pega o que esta na requisição e coloca no objeto livro
	    livro = livrosService.salvar(livro);
		
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//Buscar o livro por um determinado ID passado na URI: "/{id}" <- variavel
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar (@PathVariable Long id){ //Pego o valor na variavel acima 
		//Trantando as respostas: ResponseEntity, notação <?> 
		
		Livro livro = livrosService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(livro);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		
		livrosService.deletar(id);	
		return ResponseEntity.noContent().build(); //Não há conteudo encontrado
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Livro livro, @PathVariable("id") Long id){
		livro.setId(id); //Confirmando o ID que quero atualizar
		livrosService.salvar(livro);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long livroId, 
			@RequestBody Comentario comentario){
		
		livrosService.salvarComentario(livroId, comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build(); 
	}
	
	@RequestMapping(value="/{id}/comentarios", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> listarComentarios(
			@PathVariable("id")Long livroId){
		
		List<Comentario> comentarios = livrosService.listarComentarios(livroId);
		
		return ResponseEntity.status(HttpStatus.OK).body(comentarios); 
	}
}

