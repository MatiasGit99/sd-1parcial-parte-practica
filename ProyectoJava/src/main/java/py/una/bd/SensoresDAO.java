package py.una.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.una.entidad.Persona;
import py.una.entidad.SensoresMeteorologicos;

public class SensoresDAO {
 
	/**
	 * 
	 * @param condiciones 
	 * @return
	 */

    public int insertar(SensoresMeteorologicos p) throws SQLException {

        String SQL = "INSERT INTO SensoresMeteorologicos(id_estacion, ciudad,porcentaje_humedad, temperatura, velocidad_viento) "
                + "VALUES(?,?,?,?,?)";
 
        int id = 0;
        Connection conn = null;
        
        try 
        {
        	conn = Bd.connect();
        	PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, p.getId_estacion());
            pstmt.setString(2, p.getCiudad());
            pstmt.setDouble(3, p.getPorcentaje_humedad());
            pstmt.setDouble(4, p.getTemperatura());
            pstmt.setDouble(5   , p.getVelocidad_viento());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la insercion: " + ex.getMessage());
        }
        finally  {
        	try{
        		conn.close();
        	}catch(Exception ef){
        		System.out.println("No se pudo cerrar la conexion a BD: "+ ef.getMessage());
        	}
        }
        	
        return id;
    	
    	
    }
	
    

}
