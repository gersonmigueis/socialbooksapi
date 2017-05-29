package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.execeptions.AutorExistenteException;
import com.algaworks.socialbooks.execeptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.execeptions.LivroNaoEncontradoException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException
							(LivroNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro nao pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis()); /*Retornando o erro em milisegundos */
				 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro); 
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteExceptionException
							(AutorExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Autor ja existente");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis()); /*Retornando o erro em milisegundos */
				 
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro); 
	}

	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoExceptionException
							(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Autor não encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis()); /*Retornando o erro em milisegundos */
				 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro); 
	}
	//Tratando a exceção ao tentar cadastrar o livro com um autor não existente 
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis()); /*Retornando o erro em milisegundos */
				 //Bad_Request pra dizer hoo que você fez aí não esta muito interessante não. 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro); 
	}

}