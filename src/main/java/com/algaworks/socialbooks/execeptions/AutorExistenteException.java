package com.algaworks.socialbooks.execeptions;

public class AutorExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882382606990740715L;
	
	public AutorExistenteException(String mensagem){
		super(mensagem);
	}
	public AutorExistenteException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
