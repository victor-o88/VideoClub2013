/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionar;

import datosPeliculas.Multa;
import datosPersona.Cliente;
import excepciones.DateAccessException;
import java.util.ArrayList;
import persistencia.MultasDAO;

/**
 *
 * @author Administrador
 */
public class GestorMultas {
    
    private ArrayList multas = new ArrayList();
    private MultasDAO multasDAO = new MultasDAO();
    
    public GestorMultas() throws DateAccessException{
             //levanta todo y devuelve una collection, lo casteo y lo guardo en cuenta        
        multas = (ArrayList)multasDAO.findAll();
    }
    
    public void agregarMulta(Multa multa) throws DateAccessException{
        multasDAO.insert(multa);
        multas.add(multa);
    }
    
    public Multa buscarmultas(Integer id_mul) throws DateAccessException{
        Multa encontrado = multasDAO.findByPK(id_mul);
        return encontrado;   
    }
    
    public ArrayList listamultas() throws DateAccessException{
        ArrayList listamulta = (ArrayList) multasDAO.findAll();
        return listamulta;
    }
    
    public void pagomulta(Multa pagado)throws DateAccessException{
        multasDAO.update(pagado);
        multas.add(pagado);
    } 
}
