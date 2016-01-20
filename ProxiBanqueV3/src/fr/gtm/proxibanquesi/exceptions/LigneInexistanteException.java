package fr.gtm.proxibanquesi.exceptions;

public class LigneInexistanteException extends DaoException {

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
