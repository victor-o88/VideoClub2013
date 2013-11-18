/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionar;

import datosPersona.Cliente;
import excepciones.DateAccessException;
import java.util.ArrayList;
import persistencia.ClienteDAO;

/**
 *
 * @author Alejandrux
 */
public class GestorClientes {
    
    private ArrayList clientes = new ArrayList();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Integer id_cliente;
    
    //constructor
    public GestorClientes() throws DateAccessException{
        //levanta todo y devuelve una collection, lo casteo y lo guardo en cuenta
        //clientes=(String)clienteDAO.findAll();
    }
    
    public ArrayList listarCliente() throws DateAccessException{
        
        ArrayList listasCliente = (ArrayList) clienteDAO.findAll();
        return listasCliente;
    
    }
    //seguir a partir de aqui, crear JTable para listar
    
    public void agregarCliente(Cliente cliente) throws DateAccessException{
        
        clienteDAO.insert(cliente);//tomo el atributo cuentaDao, uso el metodo insert
        clientes.add(cliente);//loa agrego a la BD
    }
    
    public Cliente buscarCliente(Integer id_cliente) throws DateAccessException{
        
        Cliente encontrado = clienteDAO.findByPK(id_cliente);
        return encontrado;
    }

    public void eliminarCliente(String cuil) throws DateAccessException{
        
        clienteDAO.delete(cuil);
        clientes.remove(cuil);
        
    }
    
    public void modificarCliente(Cliente cliente) throws DateAccessException{
        
        clienteDAO.update(cliente);
        clientes.add(cliente);
    }
    
}
