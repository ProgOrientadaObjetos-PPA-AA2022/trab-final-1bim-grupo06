
package paquete03;

import java.io.Serializable;


public class Barrio implements Serializable{
    
    private String nombre;
    private String referencia;
    
    public Barrio(String n, String r) {
        nombre = n;
        referencia = r;
    }
    
    public void establecerNombres(String x) {
        nombre = x;
    }
    public void establecerReferencia(String x) {
        referencia = x;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public String obtenerReferencia() {
        return referencia;
    }
  
}
