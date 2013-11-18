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
public class GestorAlquileres {
    
    private ArrayList alquileres = new ArrayList();
    private AlquileresDAO alquileresDAO = new AlquileresDAO();

    public GestorAlquileres() throws DateAccessException{
             //levanta todo y devuelve una collection, lo casteo y lo guardo en cuenta        
        alquileres = (ArrayList)alquileresDAO.findAll();
    }
    
    public void agregarAlquiler(Alquileres alquiler, Peliculas pel1, Peliculas pel2, Peliculas pel3, Cliente cliente) throws DateAccessException{
        alquileresDAO.insert(alquiler, pel1, pel2, pel3, cliente);
        alquileres.add(alquiler);
    }
    
    public Alquileres buscaralquiler(Integer id_alq) throws DateAccessException{
        Alquileres encontrado = alquileresDAO.findByPK(id_alq);
        return encontrado;   
    }
    
    public ArrayList listaalquileres() throws DateAccessException{
        ArrayList listaalquileres = (ArrayList) alquileresDAO.findAll();
        return listaalquileres;
    }
    
    public ArrayList listaPeliculasAlquiladas(Integer id_alq) throws DateAccessException{
        ArrayList lpa = (ArrayList) alquileresDAO.findByPKPelicula(id_alq);
        return lpa;
    }
    
    public void devolucionoMulta(Alquileres alquiler)throws DateAccessException{
        alquileresDAO.update(alquiler);
        alquileres.add(alquiler);
    } 
    
}
