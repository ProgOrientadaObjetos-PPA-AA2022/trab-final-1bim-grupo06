
package paquete05;

public class Constructora {
    private String nombre;
    private String idEmpresa;
    
    public Constructora(String n, String r) {
        nombre = n;
        idEmpresa = r;
    }
    
    public void establecerNombres(String x) {
        nombre = x;
    }
    public void establecerIdEmpresa(String x) {
        idEmpresa = x;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public String obtenerIdEmpresa() {
        return idEmpresa;
    }
}
