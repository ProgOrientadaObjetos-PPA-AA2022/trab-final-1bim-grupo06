/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author jpvpv
 */
public class LecturaArchivoPropietario {
    
    private ObjectInputStream entrada;
    private ArrayList<Propietario> listaPropietarios;
    private String nombreArchivo;
    private String identificacion;
    private Propietario propietarioBuscado;
    
    
    public LecturaArchivoPropietario(String x) {
        nombreArchivo = x;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nombreArchivo));
            } catch (IOException ioException) {
                System.out.println(
                    "-------------------------\n"
                    + "ERROR AL ABRIR EL ARCHIVO\n"
                    + "-------------------------");
            } 
        }
    }
    
    public void establecerListaPropietarios() {
        listaPropietarios = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    listaPropietarios.add(registro);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println(
                            "------------------------\n"
                            + "ERROR AL LEER EL ARCHIVO\n"
                            + "------------------------");
                } catch (ClassNotFoundException ex) {
                    System.out.println(
                            "--------------------------\n"
                            + "NO SE PUDO CREAR EL OBJETO" + ex + "\n"
                            + "--------------------------");
                }
            }
        }

    }
    
    public void establecerNombreArchivo(String x) {
        nombreArchivo = x;
    }
    
    public void establecerIdentificacion(String x) {
        identificacion = x;
    }
    
    public void establecerPropietarioBuscado() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    if(registro.obtenerIdentificacion().equals(identificacion)){
                        propietarioBuscado = registro;
                        break;
                    }
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println(
                        "------------------------\n"
                        + "ERROR AL LEER EL ARCHIVO\n"
                        + "------------------------");
                } catch (ClassNotFoundException ex) {
                    System.out.println(
                        "--------------------------\n"
                        + "NO SE PUDO CREAR EL OBJETO" + ex + "\n"
                        + "--------------------------");
                }
                
            }
            
        }
    }
    
    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listaPropietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerIdentificacion() {
        return identificacion;
    }
        
    public Propietario obtenerPropietarioBuscado() {
        return propietarioBuscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n" +
                "--------------------\n";
        for (int i = 0; i < listaPropietarios.size(); i++) {
            Propietario p = listaPropietarios.get(i);
            cadena = String.format("%s(%d) %s-%s-%s\n", cadena,
                    i + 1,
                    p.obtenerNombres(),
                    p.obtenerApellidos(),
                    p.obtenerIdentificacion());
        }

        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println(
                "--------------------------\n"
                + "ERROR AL CERRAR EL ARCHIVO\n"
                + "--------------------------");
        }
    }
}
