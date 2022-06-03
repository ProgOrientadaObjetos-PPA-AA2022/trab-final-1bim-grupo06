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
        int op1, op2, op3 = 0;
        String a, b, c, d, edificio, ubicacion;
        int f;
        double m2, nm2, ali;
        String nombreArchivoPropietario = "datos/Propietarios.dat";
        String nombreArchivoBarrio = "datos/Barrios.dat";
        String nombreArchivoCiudad = "datos/Ciudades.dat";
        String nombreArchivoConstructora = "datos/Constructoras.dat";
        String nombreArchivoCasa = "datos/Casas.dat";
        String nombreArchivoDepartamento = "datos/Departamento.dat";
        Propietario propietario2;
        Barrio barrio2;
        Ciudad ciudad2;
        Constructora constructora2;
        do {
            System.out.println("--------------------------------");
            System.out.println("Elija que accion desea realizar:");
            System.out.println("1) Ingresar");
            System.out.println("2) Listar");
            System.out.println("0) Salir");
            op1 = sc.nextInt();
            if (op1 == 1) {

                do {
                    System.out.println("--------------------------------");
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
                    label:
                    {
                        
                        switch (op2) {
                            
                            case 1:
                                System.out.println("Ingrese los nombres del Propietario");
                                a = sc.nextLine();
                                System.out.println("Ingrese los apellidos del propietario");
                                b = sc.nextLine();
                                System.out.println("Ingrese la identificacion del propitario");
                                c = sc.nextLine();
                                Propietario p = new Propietario(a, b, c);
                                EscrituraArchivoPropietario archivoPropietario = new EscrituraArchivoPropietario(nombreArchivoPropietario);
                                archivoPropietario.establecerRegistro(p);
                                archivoPropietario.establecerSalida();
                                archivoPropietario.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "PROPIETARIO INGRESADO CON EXITO!");
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre del Barrio");
                                a = sc.nextLine();
                                System.out.println("Ingrese la referencia del Barrio");
                                b = sc.nextLine();
                                Barrio b1 = new Barrio(a, b);
                                EscrituraArchivoBarrio archivoBarrio = new EscrituraArchivoBarrio(nombreArchivoBarrio);
                                archivoBarrio.establecerRegistro(b1);
                                archivoBarrio.establecerSalida();
                                archivoBarrio.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "BARRIO INGRESADO CON EXITO!");
                                break;
                            case 3:
                                System.out.println("Ingrese el nombre de la Ciudad");
                                a = sc.nextLine();
                                System.out.println("Ingrese el nombre de la Provincia");
                                b = sc.nextLine();
                                Ciudad c1 = new Ciudad(a, b);
                                EscrituraArchivoCiudad archivoCiudad = new EscrituraArchivoCiudad(nombreArchivoCiudad);
                                archivoCiudad.establecerRegistro(c1);
                                archivoCiudad.establecerSalida();
                                archivoCiudad.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "CIUDAD INGRESADO CON EXITO!");
                                break;
                            case 4:
                                System.out.println("Ingrese el nombre de la Constructora");
                                a = sc.nextLine();
                                System.out.println("Ingrese el ID de la Empresa");
                                b = sc.nextLine();
                                Constructora co1 = new Constructora(a, b);
                                EscrituraArchivoConstructora archivoConstructora = new EscrituraArchivoConstructora(nombreArchivoConstructora);
                                archivoConstructora.establecerRegistro(co1);
                                archivoConstructora.establecerSalida();
                                archivoConstructora.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "CONSTRUCTORA INGRESADO CON EXITO!");
                                break;

                            case 5:
                                
                                do {
                                    System.out.println("Ingrese la identificacion del Propietario de la Casa");
                                    a = sc.nextLine();
                                    LecturaArchivoPropietario datosPropietarioCasa = new LecturaArchivoPropietario(nombreArchivoPropietario);
                                    datosPropietarioCasa.establecerIdentificacion(a);
                                    datosPropietarioCasa.establecerPropietarioBuscado();
                                    propietario2 = datosPropietarioCasa.obtenerPropietarioBuscado();
                                    if (propietario2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "EL PROPIETARIO INGRESADO NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar propietarios disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoPropietario datosPropietarios = new LecturaArchivoPropietario(nombreArchivoPropietario);
                                                    datosPropietarios.establecerListaPropietarios();
                                                    System.out.println(datosPropietarios);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (propietario2 == null);
                                System.out.println("Ingrese el precio por metro cuadrado de la Casa");
                                m2 = sc.nextDouble();
                                System.out.println("Ingrese el numero de metros cuadrados de la Casa");
                                nm2 = sc.nextDouble();
                                sc.nextLine();
                                do {
                                    System.out.println("Ingrese el nombre del Barrio de la Casa");
                                    b = sc.nextLine();
                                    LecturaArchivoBarrio datosBarrioCasa = new LecturaArchivoBarrio(nombreArchivoBarrio);
                                    datosBarrioCasa.establecerNombre(b);
                                    datosBarrioCasa.establecerBarrioBuscado();
                                    barrio2 = datosBarrioCasa.obtenerBarrioBuscado();
                                    if (barrio2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "EL BARRIO INGRESADO NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Barrios disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoBarrio datosBarrios = new LecturaArchivoBarrio(nombreArchivoBarrio);
                                                    datosBarrios.establecerListaBarrios();
                                                    System.out.println(datosBarrios);;
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (barrio2 == null);
                                do {
                                    System.out.println("Ingrese el nombre de la Ciudad de la Casa");
                                    c = sc.nextLine();
                                    LecturaArchivoCiudad datosCiudadCasa = new LecturaArchivoCiudad(nombreArchivoCiudad);
                                    datosCiudadCasa.establecerNombre(c);
                                    datosCiudadCasa.establecerCiudadBuscado();
                                    ciudad2 = datosCiudadCasa.obtenerCiudadBuscado();
                                    if (ciudad2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "La CIUDAD INGRESADA NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Ciudades disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoCiudad datosCiudades = new LecturaArchivoCiudad(nombreArchivoCiudad);
                                                    datosCiudades.establecerListaCiudades();
                                                     System.out.println(datosCiudades);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (ciudad2 == null);
                                System.out.println("Ingrese el numero de cuartos de la Casa");
                                f = sc.nextInt();
                                sc.nextLine();
                                do {
                                    System.out.println("Ingrese el ID de la Constructora de la Casa");
                                    d = sc.nextLine();
                                    LecturaArchivoConstructora datosConstructoraCasa = new LecturaArchivoConstructora(nombreArchivoConstructora);
                                    datosConstructoraCasa.establecerIdConstructora(d);
                                    datosConstructoraCasa.establecerConstructoraBuscado();
                                    constructora2 = datosConstructoraCasa.obtenerConstructoraBuscado();
                                    if (constructora2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "La CONSTRUCTORA INGRESADA NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Constructoras disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoConstructora datosConstructoras = new LecturaArchivoConstructora(nombreArchivoConstructora);
                                                    datosConstructoras.establecerListaConstructoras();
                                                    System.out.println(datosConstructoras);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (constructora2 == null);
                                Casa ca1 = new Casa(propietario2, m2, nm2, barrio2, ciudad2, f, constructora2);
                                ca1.calcularCostoFinal();
                                EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa(nombreArchivoCasa);
                                archivoCasa.establecerRegistro(ca1);
                                archivoCasa.establecerSalida();
                                archivoCasa.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "CASA INGRESADO CON EXITO!");
                                break;
                            case 6:
                                do {
                                    System.out.println("Ingrese la identificacion del Propietario del Departamento");
                                    a = sc.nextLine();
                                    LecturaArchivoPropietario datosPropietarioDepartamento = new LecturaArchivoPropietario(nombreArchivoPropietario);
                                    datosPropietarioDepartamento.establecerIdentificacion(a);
                                    datosPropietarioDepartamento.establecerPropietarioBuscado();
                                    propietario2 = datosPropietarioDepartamento.obtenerPropietarioBuscado();
                                    if (propietario2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "EL PROPIETARIO INGRESADO NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar propietarios disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoPropietario datosPropietarios = new LecturaArchivoPropietario(nombreArchivoPropietario);
                                                    datosPropietarios.establecerListaPropietarios();
                                                    System.out.println(datosPropietarios);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (propietario2 == null);
                                System.out.println("Ingrese el precio por metro cuadrado del Departamento");
                                m2 = sc.nextDouble();
                                System.out.println("Ingrese el numero de metros cuadrados del Departamento");
                                nm2 = sc.nextDouble();
                                System.out.println("Ingrese el valor de la alicuota mensual del Departamento");
                                ali = sc.nextDouble();
                                sc.nextLine();
                                do {
                                    System.out.println("Ingrese el nombre del Barrio del Departamento");
                                    b = sc.nextLine();
                                    LecturaArchivoBarrio datosBarrioDepartamento = new LecturaArchivoBarrio(nombreArchivoBarrio);
                                    datosBarrioDepartamento.establecerNombre(b);
                                    datosBarrioDepartamento.establecerBarrioBuscado();
                                    barrio2 = datosBarrioDepartamento.obtenerBarrioBuscado();
                                    if (barrio2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "EL BARRIO INGRESADO NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Barrios disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoBarrio datosBarrios = new LecturaArchivoBarrio(nombreArchivoBarrio);
                                                    datosBarrios.establecerListaBarrios();
                                                    System.out.println(datosBarrios);;
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (barrio2 == null);
                                do {
                                    System.out.println("Ingrese el nombre de la Ciudad del Departamento");
                                    c = sc.nextLine();
                                    LecturaArchivoCiudad datosCiudadDepartamento = new LecturaArchivoCiudad(nombreArchivoCiudad);
                                    datosCiudadDepartamento.establecerNombre(c);
                                    datosCiudadDepartamento.establecerCiudadBuscado();
                                    ciudad2 = datosCiudadDepartamento.obtenerCiudadBuscado();
                                    if (ciudad2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "La CIUDAD INGRESADA NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Ciudades disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoCiudad datosCiudades = new LecturaArchivoCiudad(nombreArchivoCiudad);
                                                    datosCiudades.establecerListaCiudades();
                                                     System.out.println(datosCiudades);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (ciudad2 == null);
                                System.out.println("Ingrese el nombre del edificio del Departamento");
                                edificio = sc.nextLine();
                                System.out.println("Ingrese la ubicacion del Departamento en el edificio");
                                ubicacion = sc.nextLine();
                                do {
                                    System.out.println("Ingrese el ID de la Constructora del Departamento");
                                    d = sc.nextLine();
                                    LecturaArchivoConstructora datosConstructoraCasa = new LecturaArchivoConstructora(nombreArchivoConstructora);
                                    datosConstructoraCasa.establecerIdConstructora(d);
                                    datosConstructoraCasa.establecerConstructoraBuscado();
                                    constructora2 = datosConstructoraCasa.obtenerConstructoraBuscado();
                                    if (constructora2 == null) {
                                        System.out.println(
                                                "---------------------------------\n"
                                                + "La CONSTRUCTORA INGRESADA NO EXISTE!\n"
                                                + "---------------------------------");
                                        OUTER:
                                        do {
                                            System.out.println("1) Intentar de nuevo");
                                            System.out.println("2) Listar Constructoras disponibles");
                                            System.out.println("0) Salir");
                                            op3 = sc.nextInt();
                                            sc.nextLine();
                                            switch (op3) {
                                                case 0:
                                                    break label;
                                                case 1:
                                                    break OUTER;
                                                case 2:
                                                    LecturaArchivoConstructora datosConstructoras = new LecturaArchivoConstructora(nombreArchivoConstructora);
                                                    datosConstructoras.establecerListaConstructoras();
                                                    System.out.println(datosConstructoras);
                                                    break;
                                                default:
                                                    System.out.println(
                                                        "--------------------------------\n"
                                                        + "INGRESE UNA OPCION VALIDA\n"
                                                        + "--------------------------------");
                                                    break;
                                            }
                                        } while (op3 != 0);
                                    }
                                } while (constructora2 == null);
                                Departamento dep1 = new Departamento(propietario2, m2, nm2, ali, barrio2, ciudad2, edificio, ubicacion, constructora2);
                                dep1.calcularCostoFinal();
                                EscrituraArchivoDepartamento archivoDepartamento = new EscrituraArchivoDepartamento(nombreArchivoDepartamento);
                                archivoDepartamento.establecerRegistro(dep1);
                                archivoDepartamento.establecerSalida();
                                archivoDepartamento.cerrarArchivo();
                                System.out.println(
                                        "--------------------------------\n"
                                        + "DEPARTAMENTO INGRESADO CON EXITO!");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println(
                                        "--------------------------------\n"
                                        + "INGRESE UNA OPCION VALIDA");
                                break;
                        }
                    }
                } while (op2 != 0);

            } else if (op1 == 2) {

                do {
                    System.out.println("--------------------------------");
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

                    switch (op2) {
                        case 1:
                            LecturaArchivoPropietario datosPropietarios = new LecturaArchivoPropietario(nombreArchivoPropietario);
                            datosPropietarios.establecerListaPropietarios();
                            System.out.println(datosPropietarios);
                            break;
                        case 2:
                            LecturaArchivoBarrio datosBarrios = new LecturaArchivoBarrio(nombreArchivoBarrio);
                            datosBarrios.establecerListaBarrios();
                            System.out.println(datosBarrios);
                            break;
                        case 3:
                            LecturaArchivoCiudad datosCiudades = new LecturaArchivoCiudad(nombreArchivoCiudad);
                            datosCiudades.establecerListaCiudades();
                            System.out.println(datosCiudades);
                            break;
                        case 4:
                            LecturaArchivoConstructora datosConstructoras = new LecturaArchivoConstructora(nombreArchivoConstructora);
                            datosConstructoras.establecerListaConstructoras();
                            System.out.println(datosConstructoras);
                            break;
                        case 5:
                            LecturaArchivoCasa datosCasas = new LecturaArchivoCasa(nombreArchivoCasa);
                            datosCasas.establecerListaCasas();
                            System.out.println(datosCasas);
                            break;
                        case 6:
                            LecturaArchivoDepartamento datosDepartamentos = new LecturaArchivoDepartamento(nombreArchivoDepartamento);
                            datosDepartamentos.establecerListaDepartamentos();
                            System.out.println(datosDepartamentos);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println(
                                    "--------------------------------\n"
                                    + "INGRESE UNA OPCION VALIDA");
                            break;
                    }

                } while (op2 != 0);

            } else if (op1 != 0) {
                System.out.println(
                        "--------------------------------\n"
                        + "INGRESE UNA OPCION VALIDA");
            }
        } while (op1 != 0);

    }
    
 

}
