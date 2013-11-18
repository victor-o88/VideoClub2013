
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cevisy;

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
public class CeViSy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    Inicio cevisi = new Inicio();
    cevisi.setVisible(true);
        
  }        

         public Date calcfecha(){
            java.util.Date d = new java.util.Date();
            java.sql.Date f;
            f = new java.sql.Date(d.getTime());
            return f;
        }
        
    }

