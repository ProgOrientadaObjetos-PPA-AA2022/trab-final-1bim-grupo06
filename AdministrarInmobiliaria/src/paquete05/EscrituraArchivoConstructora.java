/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author jpvpv
 */
public class EscrituraArchivoConstructora {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registro;
    private ArrayList<Constructora> listaConstructoras;
    
    public EscrituraArchivoConstructora(String x) {
        nombreArchivo = x;
        establecerListaConstructoras();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaConstructoras.size() > 0) {
                for (int i = 0; i < listaConstructoras.size(); i++) {
                    establecerRegistro(listaConstructoras.get(i));
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
    
    public void establecerRegistro(Constructora x) {
        registro = x;
    }
    
    public void establecerListaConstructoras() {
        LecturaArchivoConstructora x = new LecturaArchivoConstructora(nombreArchivo);
        x.establecerListaConstructoras();
        listaConstructoras = x.obtenerListaConstructoras();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Constructora> obtenerListaConstructoras() {
        return listaConstructoras;
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
