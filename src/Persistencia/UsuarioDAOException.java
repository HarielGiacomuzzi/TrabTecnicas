package Persistencia;

import java.sql.SQLException;

public class UsuarioDAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = null;
	
	public UsuarioDAOException(String message) {
		this.message = message;
	}

	public UsuarioDAOException(String string, SQLException ex) {
		this.message = string + ex.getErrorCode();
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
