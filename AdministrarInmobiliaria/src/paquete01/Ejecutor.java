/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

/**
 *
 * @author Jean Valarezo, Ana Churo
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("INMOBILIARIA");
        System.out.println("------------");
        int op1, op2;
        String nombreArchivo;
        do {
            System.out.println("Elija que accion desea realizar:");
            System.out.println("1) Ingresar");
            System.out.println("2) Listar");
            System.out.println("0) Salir");
            op1 = sc.nextInt();
            
            if (op1 == 1) {
                
                do {
                    System.out.println("Elija que desea ingresar:");
                    System.out.println("1) Propietario");
                    System.out.println("2) Barrio");
                    System.out.println("3) Ciudad");
                    System.out.println("4) Constructora");
                    System.out.println("5) Casa");
                    System.out.println("6) Departamento");
                    System.out.println("0) Volver");
                    op2 = sc.nextInt();
                    sc.nextLine();
                    
                    switch ( op2 ) {
                        case 1: 
                            System.out.println("Ingrese los nombres del Propietario"); 
                            String a = sc.nextLine();
                            System.out.println("Ingrese los apellidos del propietario");
                            String b = sc.nextLine();
                            System.out.println("Ingrese la identificacion del propitario");
                            String c = sc.nextLine();
                            Propietario p = new Propietario(a,b,c);
                            nombreArchivo = "data/Propietarios.dat";
                            EscrituraArchivoPropietario archivo = new EscrituraArchivoPropietario(nombreArchivo);
                            archivo.establecerRegistro(p);
                            archivo.establecerSalida();  
                            archivo.cerrarArchivo();
                            System.out.println(
                                "--------------------------------\n"
                                + "PROPIETARIO INGRESADO CON EXITO!\n"
                                + "--------------------------------");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 0:
                            break;
                        default: 
                            System.out.println(
                                "------------------------\n"
                                + "INGRESE UNA OPCION VALIDA\n"
                                + "------------------------");
                            break;
                    }
                } while ( op2 != 0);
                
            } else if(op1 == 2) {
                
                do {
                    System.out.println("Elija que desea Listar:");
                    System.out.println("1) Propietarios");
                    System.out.println("2) Barrios");
                    System.out.println("3) Ciudades");
                    System.out.println("4) Constructoras");
                    System.out.println("5) Casas");
                    System.out.println("6) Departamentos");
                    System.out.println("0) Volver");
                    op2 = sc.nextInt();
                    sc.nextLine();
                    
                    switch ( op2 ) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 0:
                            break;
                        default: 
                            System.out.println(
                                "------------------------\n"
                                + "INGRESE UNA OPCION VALIDA\n"
                                + "------------------------");
                            break;
                    }
                    
                } while ( op2 != 0);
              
            } else if (op1 != 0) {
                System.out.println(
                        "------------------------\n"
                        + "INGRESE UNA OPCION VALIDA\n"
                        + "------------------------");
            }
        } while (op1 != 0);

    }

}
