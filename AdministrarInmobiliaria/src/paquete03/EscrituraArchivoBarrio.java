/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jpvpv
 */
public class EscrituraArchivoBarrio {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> listaBarrios;
    
    public EscrituraArchivoBarrio(String x) {
        nombreArchivo = x;
        establecerListaBarrios();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaBarrios.size() > 0) {
                for (int i = 0; i < listaBarrios.size(); i++) {
                    establecerRegistro(listaBarrios.get(i));
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
    
    public void establecerRegistro(Barrio x) {
        registro = x;
    }
    
    public void establecerListaBarrios() {
        LecturaArchivoBarrio x = new LecturaArchivoBarrio(nombreArchivo);
        x.establecerListaBarrios();
        listaBarrios = x.obtenerListaBarrios();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Barrio> obtenerListaPropietarios() {
        return listaBarrios;
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
