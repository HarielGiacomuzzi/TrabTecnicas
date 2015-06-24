package Persistencia;

import java.sql.SQLException;

public class LeilaoDAOException extends Exception {
	String message;
	public LeilaoDAOException(String message) {
		this.message = message;
	}

	public LeilaoDAOException(String string, SQLException ex) {
		this.message = string + " " + ex.getErrorCode();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
