
package paquete02;

import java.io.Serializable;

public class Propietario implements Serializable {

    private String nombres;
    private String apellidos;
    private String identificacion;
    
    public Propietario(String n, String a, String i) {
        nombres = n;
        apellidos = a;
        identificacion = i;
    }
    public void establecerNombres(String x) {
        nombres = x;
    }
    public void establecerApellidos(String x) {
        apellidos = x;
    }
    
    public void establecerIdentificacion(String x) {
        identificacion = x;
    }
    
    public String obtenerNombres() {
        return nombres;
    }
    
    public String obtenerApellidos() {
        return apellidos;
    }
    
    public String obtenerIdentificacion() {
        return identificacion;
    }
}
