
package paquete06;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Casa {
    private Propietario propietario;
    private double preciom2;
    private double nm2;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int nCuartos;
    private Constructora constructora;
    
    public Casa(
            Propietario p, double pm2, double nm, Barrio b, Ciudad ci, int n, Constructora cons) {
        propietario = p;
        preciom2 = pm2;
        nm2 = nm;
        barrio = b;
        ciudad = ci;
        nCuartos = n;
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
    
    public void calcularCostoFinal() {
        costoFinal = preciom2 * nm2;
    }
    
    public void establecerBarrio(Barrio x) {
        barrio = x;
    }
    
    public void establecerCiudad(Ciudad x) {
        ciudad = x;
    }
    
    public void establecerNCuartos(int x) {
        nCuartos = x;
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
    
    public double obtenerCostoFinal() {
        return costoFinal;
    }
    
    public Barrio obtenerBarrio() {
        return barrio;
    }
    
    public Ciudad obtenerCiudad() {
        return ciudad;
    }
    
    public int obtenerNCuartos() {
        return nCuartos;
    }
    
    public Constructora obtenerConstructora() {
        return constructora;
    }
  
}
