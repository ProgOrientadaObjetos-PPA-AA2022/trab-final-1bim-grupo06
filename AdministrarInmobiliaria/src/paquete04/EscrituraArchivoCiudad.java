/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author jpvpv
 */
public class EscrituraArchivoCiudad {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad registro;
    private ArrayList<Ciudad> listaCiudades;
    
    public EscrituraArchivoCiudad(String x) {
        nombreArchivo = x;
        establecerListaCiudades();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaCiudades.size() > 0) {
                for (int i = 0; i < listaCiudades.size(); i++) {
                    establecerRegistro(listaCiudades.get(i));
                    establecerSalida();
                }
            }
            
        } catch (IOException IOexception) {
            System.out.println(
                    "-------------------------\n"
                    + "ERROR AL ABRIR EL ARCHIVO\n"
                    + "-------------------------");
        }
    }
    
    public void establecerNombreArchivo(String x) {
        nombreArchivo = x;
    }
    
    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println(
                    "-------------------------------\n"
                    + "ERROR AL ESCRIBIR EN EL ARCHIVO\n"
                    + "-------------------------------");
        }
    }
    
    public void establecerRegistro(Ciudad x) {
        registro = x;
    }
    
    public void establecerListaCiudades() {
        LecturaArchivoCiudad x = new LecturaArchivoCiudad(nombreArchivo);
        x.establecerListaCiudades();
        listaCiudades = x.obtenerListaCiudades();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Ciudad> obtenerListaCiudades() {
        return listaCiudades;
    }
    
    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.out.println(
                "--------------------------\n"
                + "ERROR AL CERRAR EL ARCHIVO\n"
                + "--------------------------");
        } 
    } 
}
