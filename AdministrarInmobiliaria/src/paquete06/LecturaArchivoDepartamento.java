/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

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
public class LecturaArchivoDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> listaDepartamentos;
    private String nombreArchivo;
    
    
    
    public LecturaArchivoDepartamento(String x) {
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
    
    public void establecerListaDepartamentos() {
        listaDepartamentos = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    listaDepartamentos.add(registro);
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
    
    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return listaDepartamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
      
    
    @Override
    public String toString() {
        String cadena = "Lista de departamentos\n";
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            Departamento p = listaDepartamentos.get(i);
            cadena = String.format("%s%s", cadena, "--------------------------------\n");
            cadena = String.format("%s(%d) Propietario:\n" 
                    + "\t%s - %s - %s\n"
                    + "    Precio del metro cuadrado del departamento: %.2f\n"
                    + "    Numero de metros cuadrados del departamento: %.2f\n"
                    + "    Valor de la alicuota mensual del departamento: %.2f"
                    + "\tCosto final del departamento: %.2f\n"
                    + "    Barrio:\n"
                    + "\t%s - %s\n"
                    + "    Ciudad:\n"
                    + "\t%s - %s\n"
                    + "    Nombre del edificio del departamento: %s\n"
                    + "    Ubicacion del departamento en el edificio: %s\n"
                    + "    Constructora:\n"
                    + "\t%s - %s\n",
                    cadena,
                    i + 1,
                    p.obtenerPropietario().obtenerNombres(),
                    p.obtenerPropietario().obtenerApellidos(),
                    p.obtenerPropietario().obtenerIdentificacion(),
                    p.obtenerPreciom2(),
                    p.obtenerAlicuota(),
                    p.obtenerNm2(),
                    p.obtenerCostoFinal(),
                    p.obtenerBarrio().obtenerNombre(),
                    p.obtenerBarrio().obtenerReferencia(),
                    p.obtenerCiudad().obtenerNombre(),
                    p.obtenerCiudad().obtenerProvincia(),
                    p.obtenerNombreEdificio(),
                    p.obtenerUbicacion(),
                    p.obtenerConstructora().obtenerNombre(),
                    p.obtenerConstructora().obtenerIdEmpresa()
                    );
        }
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
