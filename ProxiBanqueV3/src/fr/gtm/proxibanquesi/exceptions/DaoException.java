package fr.gtm.proxibanquesi.exceptions;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2651825883487274889L;
	private String message = "Database Exception";
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
