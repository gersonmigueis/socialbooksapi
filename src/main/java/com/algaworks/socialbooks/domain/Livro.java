package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



//classe para representação dos livros
@Entity //Entidade em JPA
public class Livro {

	@JsonInclude(Include.NON_NULL) //Só vai mostrar os valores desse campo quando eles não forem nulos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //politica de como nosso ID vai trabalhar
	private Long id; 
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private Date publicacao; 
	
	@JsonInclude(Include.NON_NULL)
	private String editora; 
	
	@JsonInclude(Include.NON_NULL)
	private String resumo; 
	
	@JsonInclude(Include.NON_NULL)
	@Transient //Outra tabela, no momento ele não vai utilizar esse comentario
	private List<Comentario> comentario; 
	
	@JsonInclude(Include.NON_NULL)
	private String autor;
	
	public Livro(){}
	
	public Livro(String nome){
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	} 
	
	
}
