package com.algaworks.socialbooks.execeptions;

public class LivroNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882382606990740715L;
	
	public LivroNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public LivroNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
