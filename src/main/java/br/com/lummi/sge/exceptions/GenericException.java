package br.com.lummi.sge.exceptions;

public class GenericException  extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5373954433657652239L;

	public GenericException() {
		super();
	}
	
	public GenericException(String message) {
		super(message);
	}
	
	public GenericException(Throwable causa) {
		super(causa);
	}
	

}
