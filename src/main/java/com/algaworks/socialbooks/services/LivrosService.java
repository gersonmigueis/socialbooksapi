package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.execeptions.LivroNaoEncontradoException;
import com.algaworks.socialbooks.repository.ComentariosRepository;
import com.algaworks.socialbooks.repository.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRespository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id){
		Livro livro = livrosRepository.findOne(id);
		
		if(livro == null){
			throw new LivroNaoEncontradoException("O livro não pode ser foi encontrado");
		}
		return livro;
	}
	
	public Livro salvar(Livro livro){
		livro.setId(null);	
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id){
		try {
			livrosRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
	}
	 
	public void atualizar(Livro livro){
		verificarExistencia(livro);
		livrosRepository.save(livro);	
	}
	
	public void verificarExistencia(Livro livro){
		buscar(livro.getId());
		
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario){
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRespository.save(comentario);
	}
	//listando todos os comentarios 
	public List<Comentario> listarComentarios (Long livroId){
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
}
