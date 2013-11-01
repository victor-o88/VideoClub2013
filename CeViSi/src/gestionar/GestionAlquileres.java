/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionar;

import datosPeliculas.Alquileres;
import datosPeliculas.Peliculas;
import datosPersona.Cliente;
import excepciones.DateAccessException;
import java.util.ArrayList;
import persistencia.AlquileresDAO;

/**
 *
 * @author Alejandrux
 */
public class GestionAlquileres {
    
    private ArrayList alquileres = new ArrayList();
    private AlquileresDAO alquileresDAO = new AlquileresDAO();

    public GestionAlquileres() throws DateAccessException{
             //levanta todo y devuelve una collection, lo casteo y lo guardo en cuenta        
        alquileres = (ArrayList)alquileresDAO.findAll();
    }
    
    public void agregarCuenta(Alquileres alquiler, Peliculas pelicula, Cliente cliente) throws DateAccessException{
        alquileresDAO.insert(alquiler, pelicula, cliente);
        alquileres.add(alquiler);
    }
    
    
}
