
package paquete04;

public class Ciudad {
    private String nombre;
    private String provincia;
    
    public Ciudad(String n, String p) {
        nombre = n;
        provincia = p;
    }
    
    public void establecerNombre(String x) {
        nombre = x;
    }
    
    public void establcerProvincia(String x) {
        provincia = x;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public String obtenerProvincia() {
        return provincia;
    }
}
