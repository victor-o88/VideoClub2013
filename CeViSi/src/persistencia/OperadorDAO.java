/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datosPersona.Cliente;
import datosPersona.Operador;
import excepciones.DateAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Alejandrux
 */
public class OperadorDAO {
    //borrar un registro
    public void delete(Integer id_operador) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            smt.executeQuery("Delete from operador where id_operador="+id_operador);
            smt.close();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en OperadorDAO.delete() "+e);
        } 
    }
    
    //busqueda
//    public Operador findByPK(Integer id_operador) throws DateAccessException{
//        try {
//            Connection con = BaseDeDatos.getInstance();
//            Statement smt = con.createStatement();
//            
//            ResultSet result = smt.executeQuery("Select persona.nombre as Nombre, "
//                    + "persona.apellido as Apellido, persona.domicilio as Domicilio, "
//                    + "persona.telefono as Telefono, persona.cuil as CUIL, "
//                    + "operador.id_operador as Id_Operador, operador.contraseña as Contraseña "
//                    + "from persona, operador "
//                    + "where persona.cuil=operador.cuil and "
//                    + "id_operador="+id_operador);
//            
//            Operador operador = null;
//            
//            while(result.next()){
//                operador = new Operador();
//                
//                operador.setNombre(result.getString("Nombre"));
//                operador.setApellido(result.getString("Apellido"));
//                operador.setDomicilio(result.getString("Domicilio"));
//                operador.setTelefono(result.getInt("Telefono"));
//                operador.setCuil(result.getString("CUIL"));
//                operador.setIdOperador(result.getInt("Id_Operador"));
//                operador.setContraseña(result.getString("Contraseña"));
//                //operador.setConf_contraseña(result.getString("operador.conf_contraseña"));
//            }
//            
//            result.close();
//            smt.close();
//            return operador;
//            
//        } catch (Exception e) {
//            throw new DateAccessException("Error en OperadorDAO.findByPK "+e);
//        }
//    }

    //listar cuentas
//    public Collection findAll() throws DateAccessException{
//        try {
//            Connection con = BaseDeDatos.getInstance();
//            Statement smt = con.createStatement();
//            
//            ResultSet result = smt.executeQuery("Select persona.nombre as Nombre, "
//                    + "persona.apellido as Apellido, persona.domicilio as Domicilio, "
//                    + "persona.telefono as Telefono, persona.cuil as CUIL, "
//                    + "operador.id_operador as Id_Operador, "
//                    + "operador.contraseña as Contraseña  "
//                    + "from operador, persona "
//                    + "where persona.cuil = operador.cuil "
//                    + "order by operador.id_operador");
//            
//            Operador operador = null;
//            ArrayList array = new ArrayList();
//            
//            while(result.next()){
//                operador = new Operador();
//
//                    operador.setNombre(result.getString("Nombre"));
//                    operador.setApellido(result.getString("Apellido"));
//                    operador.setDomicilio(result.getString("Domicilio"));
//                    operador.setTelefono(result.getInt("Telefono"));
//                    operador.setCuil(result.getString("CUIL"));
//                    operador.setIdOperador(result.getInt("Id_Operador"));
//                    operador.setContraseña(result.getString("Contraseña"));
//                    operador.setConf_contraseña(result.getString("operador.conf_contraseña"));
//
//                    array.add(operador);
//            }
//            
//            result.close();
//            smt.close();
//            return array;
//            
//        } catch (Exception e) {
//            throw new DateAccessException("Error en OperadorDAO.findAll() "+e);
//        }
//    }
    
    
    //insertar registro
    public void insert (Operador insertRecord) throws DateAccessException{
        try {
            /*Operador existe = findByPK(insertRecord.getIdOperador());
            
            if(existe!=null){
                throw new DateAccessException("Cuenta existente en OperadorDAO.insert() ");
            }*/
            
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Insert into persona "
                    + "(cuil, nombre, apellido, domicilio, telefono) "
                    + "values (?,?,?,?,?)");
            smt.setString(1, insertRecord.getCuil());
            smt.setString(2, insertRecord.getNombre());
            smt.setString(3, insertRecord.getApellido());
            smt.setString(4, insertRecord.getDomicilio());
            smt.setInt(5, insertRecord.getTelefono());
            
            PreparedStatement smt2 = con.prepareStatement("Insert into operador "
                    + "(id_operador,cuil,contrasena) "
                    + "values (?,?,?) ");
            smt2.setInt(1, insertRecord.getIdOperador());
            smt2.setString(2, insertRecord.getCuil());
            smt2.setString(3, insertRecord.getContraseña());
            //smt2.setDate(2, insertRecord.getFechaInscripcion());
            
            smt.execute();
            smt2.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en OperadorDAO.insert() "+e);
        } 
    }
    
    //modificar
    public void update(Operador insertRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            //solo modificamos los datos de persona.  id_cliente y fecha_inscripcio de tabla cliente
            //no los modificamos
            PreparedStatement smt = con.prepareStatement("Update operador "
                    + "set domicilio=?, telefono=?"
                    + "where cuil=?");
            
            smt.setString(1, insertRecord.getDomicilio());
            smt.setInt(2, insertRecord.getTelefono());
            
            smt.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en OperadorDAO.update() "+e);
        }
        
    }

    
    //validar usuarioConttrseña
        public Operador usuarioContr(Integer id_operador, String contrasena) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select id_operador, contrasena "
                    + "from operador "
                    + "where id_operador="+id_operador+" and "
                    + "contrasena='"+contrasena+"';");
            
            Operador operador = null;
            //ArrayList ar = new ArrayList();
            
            if(result.next()){
                operador = new Operador();
                
                operador.setIdOperador(result.getInt("id_operador"));
                operador.setContraseña(result.getString("contrasena"));
                //ar.add(operador);
            }
            
            result.close();
            smt.close();
            return operador;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en OperadorDAO.usuarioContr "+e);
        }
    }

    
}
    

