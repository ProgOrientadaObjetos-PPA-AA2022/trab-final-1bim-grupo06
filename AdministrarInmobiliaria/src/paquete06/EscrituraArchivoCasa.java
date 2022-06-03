/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author jpvpv
 */
public class EscrituraArchivoCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> listaCasas;
    
    public EscrituraArchivoCasa(String x) {
        nombreArchivo = x;
        establecerListaCasas();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaCasas.size() > 0) {
                for (int i = 0; i < listaCasas.size(); i++) {
                    establecerRegistro(listaCasas.get(i));
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
    
    public void establecerRegistro(Casa x) {
        registro = x;
    }
    
    public void establecerListaCasas() {
        LecturaArchivoCasa x = new LecturaArchivoCasa(nombreArchivo);
        x.establecerListaCasas();
        listaCasas = x.obtenerListaCasas();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Casa> obtenerListaCasas() {
        return listaCasas;
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
