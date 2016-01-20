package fr.gtm.proxibanquesi.exceptions;

public class DaoException extends Exception {

	private String message = "Database Exception";
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
