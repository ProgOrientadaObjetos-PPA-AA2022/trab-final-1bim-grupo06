/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

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
public class LecturaArchivoBarrio {
    private ObjectInputStream entrada;
    private ArrayList<Barrio> listaBarrios;
    private String nombreArchivo;
    private String nombre;
    private Barrio barrioBuscado;
    
    
    public LecturaArchivoBarrio(String x) {
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
    
    public void establecerListaBarrios() {
        listaBarrios = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    listaBarrios.add(registro);
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
    
    public void establecerBarrioBuscado() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    if(registro.obtenerNombre().equals(nombre)){
                        barrioBuscado = registro;
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
    
    public ArrayList<Barrio> obtenerListaBarrios() {
        return listaBarrios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
        
    public Barrio obtenerBarrioBuscado() {
        return barrioBuscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Barrios\n" +
                "--------------------------------\n";
        for (int i = 0; i < listaBarrios.size(); i++) {
            Barrio p = listaBarrios.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    p.obtenerNombre(),
                    p.obtenerReferencia());
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
