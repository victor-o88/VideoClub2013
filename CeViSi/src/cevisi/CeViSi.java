
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cevisi;

import datosPeliculas.Alquileres;
import datosPeliculas.Peliculas;
import datosPersona.Cliente;
import datosPersona.Operador;
import excepciones.DateAccessException;
import gestionar.GestorAlquileres;
import gestionar.GestorPeliculas;
import java.util.Locale;
import gestionar.GestorClientes;
import gestionar.GestorOperadores;
import IG_Cliente.Inicio;
import IG_Cliente.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
/**
 *
 * @author Alejandrux
 */
public class CeViSi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            Cliente cliente1 = new Cliente(0001, calcfecha(), "00-33444556-0", "César Alejandro", "Ramos", "Caseros Norte", 4444444);
            GestorClientes gc1 = new GestorClientes();
            Cliente cliente2 = new Cliente(0002, calcfecha(), "00-33443557-0", "Julio César", "Ramos", "Caseros Norte", 4444445);
            GestorClientes gc2 = new GestorClientes();
            Cliente cliente3 = new Cliente(0003, calcfecha(), "00-33442558-0", "Noemi del Valle", "Seco", "Caseros Norte", 4443444);
            GestorClientes gc3 = new GestorClientes();
            
            
            GestorOperadores go1 = new GestorOperadores();
            GestorOperadores go2 = new GestorOperadores();
            GestorOperadores go3 = new GestorOperadores();
            
            
            Peliculas pelicula1 = new Peliculas("a001", "Acción", "Duro de Matar 5", "Blue Ray", "Cosito", 5);
            GestorPeliculas gpel1 = new GestorPeliculas();
            Peliculas pelicula2 = new Peliculas("a002", "Comedia", "Los Fornicas", "DVD", "xxxxx", 4);
            GestorPeliculas gpel2 = new GestorPeliculas();
            Peliculas pelicula3 = new Peliculas("a003", "Fantasía", "El Señor de los Anillos I", "DVD", "Guido Mortensen", 4);
            GestorPeliculas gpel3 = new GestorPeliculas();
            
            
            GestorAlquileres gal1 = new GestorAlquileres();
            GestorAlquileres gal2 = new GestorAlquileres();
            GestorAlquileres gal3 = new GestorAlquileres();
            
            
            //clientes
            gc1.agregarCuenta(cliente1);
            gc2.agregarCuenta(cliente2);
            gc3.agregarCuenta(cliente3);
            
            //operadores
            go1.agregarCuenta(new Operador(10, "00-22333444-0", "Victor", "Olas", "Su casa", 5555555, "1234a"));
            go2.agregarCuenta(new Operador(11, "00-33222333-0", "Charro", "Lagoria", "Cerca de la Galindez", 2223333, "2345b"));
            
            //peliculas
            gpel1.agregarCuenta(pelicula1);
            gpel2.agregarCuenta(pelicula2);
            gpel3.agregarCuenta(pelicula3);
            
            //alquiler
            Alquileres alquiler1 = new Alquileres(001, gc1, calcfecha(), 9);
            gal1.agregarCuenta(alquiler1, pelicula1, cliente1);
            
            Alquileres alquiler2 = new Alquileres(002, gc2, calcfecha(), 9);
            gal1.agregarCuenta(alquiler2, pelicula2, cliente2);
            
        } catch (DateAccessException e) {
            System.out.println(e);
        }
        finally{
            System.out.println("Otras Operaciones");
        }*/
    Inicio cevisi = new Inicio();
    cevisi.setVisible(true);
    //Principal in = new Principal();
    //in.setVisible(true);
        
  }        
        
    
         public Date calcfecha(){
            java.util.Date d = new java.util.Date();
            
            java.sql.Date f;
            
            f = new java.sql.Date(d.getTime());
            return f;
        }
        
    }

