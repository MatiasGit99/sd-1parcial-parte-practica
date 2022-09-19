package py.una.bd;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import py.una.entidad.SensoresMeteorologicos;


public class TestPersonaDAO {

	
	
	public static void main(String args[]) throws SQLException{
		
		SensoresDAO pdao = new SensoresDAO();
		
		
		pdao.insertar(new SensoresMeteorologicos(15L,"Rocio", 20.5, 20.3, 56.5) );
	
		

	}
	
	
}
