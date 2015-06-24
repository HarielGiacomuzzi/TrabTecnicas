package Persistencia;

import java.sql.SQLException;

public class CategoriaDAOException extends Exception {
	String message;
	public CategoriaDAOException(String message) {
		this.message = message;
	}

	public CategoriaDAOException(String string, SQLException ex) {
		this.message = string + " " + ex.getErrorCode();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
