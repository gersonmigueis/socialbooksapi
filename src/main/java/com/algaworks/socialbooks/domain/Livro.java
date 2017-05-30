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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@NotEmpty(message = "O campo nome não pode ser vazio.") //NotEmpty o campo não pode ser vazio 
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo publicação é de preenchimento obrigatorio.") //NotNull o campo não pode ser nulo
	private Date publicacao; 
	
	@NotNull(message = "O campo editora é de preenchimento obrigatorio.") //NotNull o campo não pode ser nulo
	@JsonInclude(Include.NON_NULL)
	private String editora; 
	
	@NotNull(message = "O campo resumo deve ser preenchido.") 
	@Size(max = 1500 ,message = "O resumo não pode conter mais de 1500 caracteres.") //Size - defino o valor maximo de caracteres do campo
	@JsonInclude(Include.NON_NULL)
	private String resumo; 
	
	//@Transient <-Outra tabela, no momento ele não vai utilizar esse comentario
	//NON_EMPTY = Não vazio 
	@JsonInclude(Include.NON_EMPTY)
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
