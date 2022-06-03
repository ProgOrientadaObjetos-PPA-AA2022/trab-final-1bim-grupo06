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
public class EscrituraArchivoDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> listaDepartamentos;
    
    public EscrituraArchivoDepartamento(String x) {
        nombreArchivo = x;
        establecerListaDepartamentos();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (listaDepartamentos.size() > 0) {
                for (int i = 0; i < listaDepartamentos.size(); i++) {
                    establecerRegistro(listaDepartamentos.get(i));
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
    
    public void establecerRegistro(Departamento x) {
        registro = x;
    }
    
    public void establecerListaDepartamentos() {
        LecturaArchivoDepartamento x = new LecturaArchivoDepartamento(nombreArchivo);
        x.establecerListaDepartamentos();
        listaDepartamentos = x.obtenerListaDepartamentos();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return listaDepartamentos;
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
