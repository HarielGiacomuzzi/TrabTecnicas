package Persistencia;

public class BemDAOException extends Exception {
	String message = null;
	public BemDAOException(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
