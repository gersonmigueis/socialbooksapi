package com.algaworks.socialbooks.execeptions;

public class AutorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882382606990740715L;
	
	public AutorNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	public AutorNaoEncontradoException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
