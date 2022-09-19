

package py.una.entidad;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SensoresMeteorologicosJSON1 {


    public static void main(String[] args) throws Exception {
        System.out.println("hola");
    }
    
     public static String objetoString(SensoresMeteorologicos p) {	
    	
	JSONObject obj = new JSONObject();
        obj.put("id_estacion", p.getId_estacion());
        obj.put("ciudad", p.getCiudad());
        obj.put("porcentaje_humedad", p.getPorcentaje_humedad());
        obj.put("temperatura", p.getTemperatura());
        obj.put("velocidad_viento", p.getVelocidad_viento());

        return obj.toJSONString();
    }
    
    
    public static SensoresMeteorologicos stringObjeto(String str) throws Exception {
        
    	SensoresMeteorologicos p = new SensoresMeteorologicos();
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(str.trim());
        JSONObject jsonObject = (JSONObject) obj;

        Long id_estacion = (Long) jsonObject.get("id_estacion");
        p.setId_estacion(id_estacion);
      
        p.setCiudad((String)jsonObject.get("ciudad"));
        Double porcentaje_humedad = (Double) jsonObject.get("porcentaje_humedad");
        p.setPorcentaje_humedad(porcentaje_humedad);
        Double temperatura = (Double) jsonObject.get("temperatura");
        p.setTemperatura(temperatura);
        Double velocidad_viento = (Double) jsonObject.get("velocidad_viento");
        p.setVelocidad_viento(velocidad_viento);
        
        
        
    /*    JSONArray msg = (JSONArray) jsonObject.get("asignaturas");
        Iterator<String> iterator = msg.iterator();
        while (iterator.hasNext()) {
        	p.getAsignaturas().add(iterator.next());
        }*/
    
        return p;
	}

}

