package Persistencia;

import java.sql.SQLException;

public class BemDAOException extends Exception {
	String message = null;
	public BemDAOException(String message) {
		this.message = message;
	}

	public BemDAOException(String string, SQLException ex) {
		this.message = string +" " + ex.getErrorCode();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
