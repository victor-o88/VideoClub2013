/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionar;

import datosPersona.Cliente;
import datosPersona.Operador;
import excepciones.DateAccessException;
import java.util.ArrayList;
import java.util.Collection;
import persistencia.ClienteDAO;
import persistencia.OperadorDAO;

/**
 *
 * @author Alejandrux
 */
public class GestorOperadores {
    private ArrayList operadores = new ArrayList();
    private OperadorDAO operadorDAO = new OperadorDAO();
    
    //constructor
    public GestorOperadores() throws DateAccessException{
             //levanta todo y devuelve una collection, lo casteo y lo guardo 
//        operadores=(ArrayList)operadorDAO.findAll();
    }
    
    public void agregarCuenta(Operador operador) throws DateAccessException{
        
        operadorDAO.insert(operador);//tomo el atributo cuentaDao, uso el metodo insert
        operadores.add(operador);//loa agrego a la BD
    }
    
    public Collection validarUsuario(Integer id_cliente, String contr) throws DateAccessException{
        
        Collection encontrado = operadorDAO.usuarioContr(id_cliente, contr);
        return encontrado;
    }
}
