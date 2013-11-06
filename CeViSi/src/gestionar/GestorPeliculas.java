/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionar;

import datosPeliculas.Peliculas;
import datosPersona.Cliente;
import excepciones.DateAccessException;
import java.util.ArrayList;
import persistencia.ClienteDAO;
import persistencia.PeliculasDAO;

/**
 *
 * @author Alejandrux
 */
public class GestorPeliculas {
    private ArrayList peliculas = new ArrayList();
    private PeliculasDAO peliculasDAO = new PeliculasDAO();
    
    //constructor
    public GestorPeliculas() throws DateAccessException{
             //levanta todo y devuelve una collection, lo casteo y lo guardo en cuenta
        peliculas=(ArrayList)peliculasDAO.findAll();
    }
    
    public void agregarCuenta(Peliculas pelicula) throws DateAccessException{
        
        peliculasDAO.insert(pelicula);//tomo el atributo cuentaDao, uso el metodo insert
        peliculas.add(pelicula);//loa agrego a la BD
    }

    public ArrayList listarPeliculas() throws DateAccessException{
        
        ArrayList listarPeliculas = (ArrayList)peliculasDAO.findAll();
        return listarPeliculas;
    }
    
    public Peliculas buscarPelicula(String cod_pelicula) throws DateAccessException{
        
        Peliculas encontrado = peliculasDAO.findByPK(cod_pelicula);
        return encontrado;
    }
    
    public void eliminarCliente(String cod_pelicula) throws DateAccessException{
        
        peliculasDAO.delete(cod_pelicula);
        peliculas.remove(cod_pelicula);
        
    }
    
    public void modificarPelicula(Peliculas pelicula) throws DateAccessException{
        
        peliculasDAO.update(pelicula);
        peliculas.add(pelicula);
    }
}
