/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

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
public class LecturaArchivoCiudad {
    private ObjectInputStream entrada;
    private ArrayList<Ciudad> listaCiudades;
    private String nombreArchivo;
    private String nombre;
    private Ciudad ciudadBuscado;
    
    
    public LecturaArchivoCiudad(String x) {
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
    
    public void establecerListaCiudades() {
        listaCiudades = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    listaCiudades.add(registro);
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
    
    public void establecerNombre(String x) {
        nombre = x;
    }
    
    public void establecerCiudadBuscado() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    if(registro.obtenerNombre().equals(nombre)){
                        ciudadBuscado = registro;
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
    
    public ArrayList<Ciudad> obtenerListaCiudades() {
        return listaCiudades;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
      
    public Ciudad obtenerCiudadBuscado() {
        return ciudadBuscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Ciudades\n" +
                "--------------------------------\n";
        for (int i = 0; i < listaCiudades.size(); i++) {
            Ciudad p = listaCiudades.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    p.obtenerNombre(),
                    p.obtenerProvincia());
        }
        cadena = String.format("%s--------------------------------", cadena);
        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.out.println(
                "--------------------------\n"
                + "ERROR AL CERRAR EL ARCHIVO\n"
                + "--------------------------");
        }
    }
}
