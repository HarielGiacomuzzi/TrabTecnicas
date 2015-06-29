package business;

import java.sql.SQLException;

public class FachadaException extends Exception {

	private static final long serialVersionUID = 12L;
	String message = null;
	
	public FachadaException(String message) {
		this.message = message;
	}

	public FachadaException(String string, SQLException ex) {
		this.message = string + ex.getErrorCode();
	}

	@Override
	public String getMessage() {
		return "Erro: \n"+message;
	}
}
