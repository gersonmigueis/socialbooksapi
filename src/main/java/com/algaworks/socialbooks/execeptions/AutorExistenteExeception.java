package com.algaworks.socialbooks.execeptions;

public class AutorExistenteExeception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882382606990740715L;
	
	public AutorExistenteExeception(String mensagem){
		super(mensagem);
	}
	public AutorExistenteExeception(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
