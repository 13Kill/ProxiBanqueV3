package fr.gtm.proxibanquesi.exceptions;

public class LigneInexistanteException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9070527593493514774L;
	private String message;
	
	public LigneInexistanteException() {
		super();
	}
	
	public LigneInexistanteException(String message) {
		this();
		this.message = super.getMessage() + ": donnée manquante. " + message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
