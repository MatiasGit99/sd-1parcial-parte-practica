
package py.una.entidad;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensoresMeteorologicos {

	Long id_estacion;
	String ciudad;
        Double porcentaje_humedad;
        Double temperatura;
        Double velocidad_viento;
       // LocalDate fecha;
        //LocalTime hora;
        
    public SensoresMeteorologicos (){
    
    }

    public SensoresMeteorologicos(Long id_estacion, String ciudad, Double porcentaje_humedad, Double temperatura, Double velocidad_viento) {
        this.id_estacion = id_estacion;
        this.ciudad = ciudad;
        this.porcentaje_humedad = porcentaje_humedad;
        this.temperatura = temperatura;
        this.velocidad_viento = velocidad_viento;
    }

    public Long getId_estacion() {
        return id_estacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Double getPorcentaje_humedad() {
        return porcentaje_humedad;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Double getVelocidad_viento() {
        return velocidad_viento;
    }

    public void setId_estacion(Long id_estacion) {
        this.id_estacion = id_estacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPorcentaje_humedad(Double porcentaje_humedad) {
        this.porcentaje_humedad = porcentaje_humedad;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public void setVelocidad_viento(Double velocidad_viento) {
        this.velocidad_viento = velocidad_viento;
    }

   
	
}
