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
public class LecturaArchivoCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> listaCasas;
    private String nombreArchivo;
    
    
    
    public LecturaArchivoCasa(String x) {
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
    
    public void establecerListaCasas() {
        listaCasas = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                
                try {
                    Casa registro = (Casa) entrada.readObject();
                    listaCasas.add(registro);
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
    
    public ArrayList<Casa> obtenerListaCasas() {
        return listaCasas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
      
    
    @Override
    public String toString() {
        String cadena = "Lista de Casas\n";
        for (int i = 0; i < listaCasas.size(); i++) {
            Casa p = listaCasas.get(i);
            cadena = String.format("%s%s", cadena, "--------------------------------\n");
            cadena = String.format("%s(%d) Propietario:\n" 
                    + "\t%s - %s - %s\n"
                    + "    Precio del metro cuadrado de la casa: %.2f\n"
                    + "    Numero de metros cuadrados de la casa: %.2f\n"
                    + "\tCosto final de la casa: %.2f\n"
                    + "    Barrio:\n"
                    + "\t%s - %s\n"
                    + "    Ciudad:\n"
                    + "\t%s - %s\n"
                    + "    Numero de cuartos de la casa: %d\n"
                    + "    Constructora:\n"
                    + "\t%s - %s\n",
                    cadena,
                    i + 1,
                    p.obtenerPropietario().obtenerNombres(),
                    p.obtenerPropietario().obtenerApellidos(),
                    p.obtenerPropietario().obtenerIdentificacion(),
                    p.obtenerPreciom2(),
                    p.obtenerNm2(),
                    p.obtenerCostoFinal(),
                    p.obtenerBarrio().obtenerNombre(),
                    p.obtenerBarrio().obtenerReferencia(),
                    p.obtenerCiudad().obtenerNombre(),
                    p.obtenerCiudad().obtenerProvincia(),
                    p.obtenerNCuartos(),
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
