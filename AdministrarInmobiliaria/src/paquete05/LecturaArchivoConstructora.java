/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

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
public class LecturaArchivoConstructora {
    private ObjectInputStream entrada;
    private ArrayList<Constructora> listaConstructoras;
    private String nombreArchivo;
    private String idEmpresa;
    private Constructora constructoraBuscado;
    
    
    public LecturaArchivoConstructora(String x) {
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
    
    public void establecerListaConstructoras() {
        listaConstructoras = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    listaConstructoras.add(registro);
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
    
    public void establecerIdConstructora(String x) {
        idEmpresa = x;
    }
    
    public void establecerConstructoraBuscado() {
        
        File f = new File(nombreArchivo);

        while (true) {
            
            if (f.exists()) {
                
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    if(registro.obtenerIdEmpresa().equals(idEmpresa)){
                        constructoraBuscado = registro;
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
    
    public ArrayList<Constructora> obtenerListaConstructoras() {
        return listaConstructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
      
    public Constructora obtenerConstructoraBuscado() {
        return constructoraBuscado;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de Constructoras\n" +
                "--------------------------------\n";
        for (int i = 0; i < listaConstructoras.size(); i++) {
            Constructora p = listaConstructoras.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    p.obtenerNombre(),
                    p.obtenerIdEmpresa());
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
