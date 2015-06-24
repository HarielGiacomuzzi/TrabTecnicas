package Persistencia;

import java.sql.SQLException;

public class LanceDAOException extends Exception {
	String message;
	public LanceDAOException(String message) {
		this.message = message;
	}

	public LanceDAOException(String string, SQLException ex) {
		this.message = string + " " + ex.getErrorCode();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
