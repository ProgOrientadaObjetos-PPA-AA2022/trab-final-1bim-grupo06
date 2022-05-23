
package paquete06;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Departamento {
    private Propietario propietario;
    private double preciom2;
    private double nm2;
    private double alicuota;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacion;
    private Constructora constructora;
    
    public Departamento (
            Propietario p, double pm2, double nm, double a, Barrio b, Ciudad ci, String ne, String u, Constructora cons) {
        propietario = p;
        preciom2 = pm2;
        nm2 = nm;
        alicuota = a;
        barrio = b;
        ciudad = ci;
        nombreEdificio = ne;
        ubicacion = u;
        constructora = cons;
    }
    
    public void establecerPropietario(Propietario x) {
        propietario = x;
    }
        
    public void establecerPreciom2(double x) {
        preciom2 = x;
    }
    
    public void establecerNm2(double x) {
        nm2 = x;
    }
    
    public void establecerAlicuota(double x) {
        alicuota = x;
    }
    
    public void calcularCostoFinal() {
        costoFinal = preciom2 * nm2;
    }
    
    public void establecerBarrio(Barrio x) {
        barrio = x;
    }
    
    public void establecerCiudad(Ciudad x) {
        ciudad = x;
    }
    
    public void establecerNombreEdificio(String x) {
        nombreEdificio = x;
    }
    
    public void establecerUbicacion(String x) {
        ubicacion = x;
    }
    
    public void establecerConstructora(Constructora x) {
        constructora= x;
    }
    
    public Propietario obtenerPropietario() {
        return propietario;
    }
    
    public double obtenerPreciom2() {
        return preciom2;
    }
    
    public double obtenerNm2() {
        return nm2;
    }
    
    public double obtenerAlicuota() {
        return alicuota;
    }
    
    public double obtenerCostoFinal() {
        return costoFinal;
    }
    
    public Barrio obtenerBarrio() {
        return barrio;
    }
    
    public Ciudad obtenerCiudad() {
        return ciudad;
    }
    
    public String obtenerNombreEdificio() {
        return nombreEdificio;
    }
    
    public String obtenerUbicacion() {
        return ubicacion;
    }
    
    public Constructora obtenerConstructora() {
        return constructora;
    }
}
