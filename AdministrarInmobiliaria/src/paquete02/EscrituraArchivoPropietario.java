/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author jpvpv
 */
public class EscrituraArchivoPropietario {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Propietario registro;
    private ArrayList<Propietario> listaPropietarios;
    
    public EscrituraArchivoPropietario(String x) {
        nombreArchivo = x;
        establecerListaPropietarios();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaPropietarios.size() > 0) {
                for (int i = 0; i < listaPropietarios.size(); i++) {
                    establecerRegistro(listaPropietarios.get(i));
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
    
    public void establecerRegistro(Propietario x) {
        registro = x;
    }
    
    public void establecerListaPropietarios() {
        LecturaArchivoPropietario x = new LecturaArchivoPropietario(nombreArchivo);
        x.establecerListaPropietarios();
        listaPropietarios = x.obtenerListaPropietarios();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listaPropietarios;
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
