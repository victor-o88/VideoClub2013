/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import excepciones.DateAccessException;
import datosPersona.Cliente;
import java.sql.*;
import java.util.*;

import excepciones.DateAccessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alejandrux
 */
public class ClienteDAO {
    
    //borrar un registro
    public void delete(String cuil) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            Statement smt2 = con.createStatement();
            
            smt.executeQuery("Delete from cliente where cuil='"+cuil+"'; "
                    + " Delete from persona where cuil='"+cuil+"';");
  
            smt.close();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en ClienteDAO.delete() "+e);
        } 
        
    }
    
    //busqueda
    public Cliente findByPK(Integer id_cliente) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select persona.nombre as Nombre, "
                    + "persona.apellido as Apellido, persona.domicilio as Domicilio, "
                    + "persona.telefono as Telefono, persona.cuil as CUIL, "
                    + "cliente.id_cliente as Id_Cliente, "
                    + "cliente.fecha_inscripcion as Fecha_Inscripcion "
                    + "from persona, cliente "
                    + "where persona.cuil=cliente.cuil and "
                    + "id_cliente="+id_cliente);
            
            Cliente cliente = null;
            
            while(result.next()){
                cliente = new Cliente();
                
                cliente.setNombre(result.getString("Nombre"));
                cliente.setApellido(result.getString("Apellido"));
                cliente.setDomicilio(result.getString("Domicilio"));
                cliente.setTelefono(result.getInt("Telefono"));
                cliente.setCuil(result.getString("CUIL"));
                cliente.setIdCliente(result.getInt("Id_Cliente"));
                cliente.setFechaInscripcion(result.getDate("Fecha_Inscripcion"));
            }
            
            result.close();
            smt.close();
            return cliente;
        } catch (Exception e) {
            throw new DateAccessException("Error en ClienteDAO.findByPK "+e);
        }
    }

    //listar cuentas
    public Collection findAll() throws DateAccessException{
        
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement(
                
                );
            ResultSet result = smt.executeQuery("Select persona.nombre as Nombre, "
                    + "persona.apellido as Apellido, persona.domicilio as Domicilio, "
                    + "persona.telefono as Telefono, persona.cuil as CUIL, "
                    + "cliente.id_cliente as Id_Cliente, "
                    + "cliente.fecha_inscripcion as Fecha_Inscripcion  "
                    + "from cliente, persona "
                    + "where persona.cuil = cliente.cuil "
                    + "order by cliente.id_cliente");
            
            Cliente cliente = null;
            
        
        ArrayList array = new ArrayList();
        
            int contador = 0;            
            while(result.next()){
                contador++;
                
                cliente = new Cliente();
                    
                    cliente.setNombre(result.getString("Nombre"));
                    cliente.setApellido(result.getString("Apellido"));
                    cliente.setDomicilio(result.getString("Domicilio"));
                    cliente.setTelefono(result.getInt("Telefono"));
                    cliente.setCuil(result.getString("CUIL"));
                    cliente.setIdCliente(result.getInt("Id_Cliente"));
                    cliente.setFechaInscripcion(result.getDate("Fecha_Inscripcion"));
                    
                    array.add(cliente);

            }

            result.close();
            smt.close();
            return array;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en ClienteDAO.findAll() "+e);
        }     
    }

    //insertar registro
    public void insert (Cliente insertRecord) throws DateAccessException{
        try {
            Cliente existe = findByPK(insertRecord.getIdCliente());
            
            if(existe!=null){
                throw new DateAccessException("Cuenta existente en ClienteDAO.insert() ");
            }
            
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Insert into persona "
                    + "(cuil, nombre, apellido, domicilio, telefono) "
                    + "values (?,?,?,?,?)");
            smt.setString(1, insertRecord.getCuil());
            smt.setString(2, insertRecord.getNombre());
            smt.setString(3, insertRecord.getApellido());
            smt.setString(4, insertRecord.getDomicilio());
            smt.setInt(5, insertRecord.getTelefono());
            
            PreparedStatement smt2 = con.prepareStatement("Insert into cliente "
                    + "(id_cliente, fecha_inscripcion, cuil) "
                    + "values (?,?,?)");
            smt2.setInt(1, insertRecord.getIdCliente());
            smt2.setDate(2, insertRecord.getFechaInscripcion());
            smt2.setString(3, insertRecord.getCuil());
            
            smt.execute();
            smt2.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en ClienteDAO.insert() "+e);
        } 
    }
    
    //modificar
    public void update(Cliente updateRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            //solo modificamos los datos de persona.  id_cliente y fecha_inscripcio 
            //de tabla cliente no los modificamos

            PreparedStatement smt = con.prepareStatement("Update persona "
                    + "set domicilio=?, telefono=?, nombre=?, apellido=? "
                    + "where cuil=?");
            smt.setString(1, updateRecord.getDomicilio());
            smt.setInt(2, updateRecord.getTelefono());
            smt.setString(3, updateRecord.getNombre());
            smt.setString(4, updateRecord.getApellido());
            smt.setString(5, updateRecord.getCuil());
           
            
            PreparedStatement smt2 = con.prepareStatement("Update cliente "
                    + "set id_cliente=?, fecha_inscripcion=? "
                    + "where cuil=?");
            smt2.setInt(1, updateRecord.getIdCliente());
            smt2.setDate(2, updateRecord.getFechaInscripcion());
            smt2.setString(3, updateRecord.getCuil());
            
            smt.execute();
            smt2.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en ClienteDAO.update() "+e);
        }
        
    }
    
}
