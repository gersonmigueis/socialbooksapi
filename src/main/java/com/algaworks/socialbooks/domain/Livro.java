package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	//@Transient <-Outra tabela, no momento ele não vai utilizar esse comentario
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios; 
	
	//Varios livros podem ter um autor n p 1
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;
	
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
	
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	public void setComentario (List<Comentario> comentarios){
		this.comentarios = comentarios;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	} 
	
	
}
