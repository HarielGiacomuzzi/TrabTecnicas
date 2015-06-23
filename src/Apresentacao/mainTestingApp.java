package Apresentacao;
import Persistencia.OracleJDBC;


public class mainTestingApp {

	public static void main(String[] args) {
		OracleJDBC a = new OracleJDBC();
		
		a.tryConnection();

	}

}
