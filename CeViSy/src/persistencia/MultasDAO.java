/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datosPeliculas.Multa;
import datosPersona.Cliente;
import excepciones.DateAccessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Administrador
 */
public class MultasDAO {
    
    //borrar
        public void delete(Integer id_multa) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            smt.executeQuery("Delete from multas where id_multa="+id_multa);
            smt.close(); 
            
        } catch (Exception e) {
            throw new DateAccessException("Error en MultasDAO.delete() "+e);
        } 
    }

        //busqueda
    public Multa findByPK(Integer id_multa) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select id_multa as Id_Multa, "
                    + "fecha_vencimiento as Fecha_Vencimiento, "
                    + "monto_multa as Monto_Multa, "
                    + "estado as Estado, id_cliente as Id_Cliente, "
                    + "id_alquiler as Id_Alquiler "
                    + "from multas "
                    + "where id_multa='"+id_multa+"'");
            
            Multa multa =null;
            
            while(result.next()){
                multa = new Multa();
                
                multa.setId_multa(result.getInt("Id_Multa"));
                multa.setMonto_multa(result.getDouble("Monto_Multa"));
                multa.setFecha_vencimiento(result.getDate("Fecha_Vencimiento"));
                multa.setEstado(result.getInt("Estado"));
                multa.setIdC(result.getInt("Id_Cliente"));
                multa.setIdAlquiler(result.getInt("Id_Alquiler"));
            }
            
            result.close();
            smt.close();
            return multa;
        } catch (Exception e) {
            throw new DateAccessException("Error en MultasDAO.findByPK "+e);
        }
    }

    
    
        //listar multas
    public Collection findAll() throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select multas.id_multa as Id_Multa, "
                    + "multas.fecha_vencimiento as Fecha_Vencimiento, "
                    //+ "persona.cuil as CUIL, multas.fecha_vencimiento as Fecha_Vencimiento, "
                    + "multas.monto_multa as Monto_Multa, "
                    + "multas.estado as Estado, multas.id_cliente as Id_Cliente, "
                    + "multas.id_alquiler as Id_Alquiler "
                    + "from multas "
                    //+ "from persona, multas "
                    //+ "where persona.cuil=multas.cuil "
                    + "order by multas.id_multa");
            
            Multa multa = null;
            
            ArrayList array = new ArrayList();
            
            while(result.next()){
                multa = new Multa();
                
                multa.setId_multa(result.getInt("Id_Multa"));
                multa.setMonto_multa(result.getDouble("Monto_Multa"));
                multa.setFecha_vencimiento(result.getDate("Fecha_Vencimiento"));
                multa.setEstado(result.getInt("Estado"));
                multa.setIdC(result.getInt("Id_Cliente"));
                multa.setIdAlquiler(result.getInt("Id_Alquiler"));

                array.add(multa);
            }
            
            result.close();
            smt.close();
            return array;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en MultasDAO.findAll() "+e);
        }
    }
    
        //insertar registro
    public void insert (Multa insertRecord) throws DateAccessException{
        try {
            Multa existe = findByPK(insertRecord.getId_multa());
                        
            if(existe!=null){
                throw new DateAccessException("Cuenta existente en AlquileresDAO.insert() ");
            }
            
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Insert into multas "
                    + "(id_multa, monto_multa, fecha_vencimiento, estado, id_cliente, id_alquiler) "
                    + "values (?,?,?,?,?,?)");
            smt.setInt(1, insertRecord.getId_multa());
            smt.setDouble(2, insertRecord.getMonto_multa());
            smt.setDate(3, insertRecord.getFecha_vencimiento());
            smt.setInt(4, insertRecord.getEstado());
            smt.setInt(5, insertRecord.getIdC());
            smt.setInt(6, insertRecord.getIdAlquiler());

            smt.execute();

        } catch (Exception e) {
            throw new DateAccessException("Error en MultasDAO.insert() "+e);
        } 
    }

        //modificar
    public void update(Multa updateRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Update multas "
                    + "set monto_multa=?, fecha_vencimiento=?, estado=?, "
                    + "id_cliente=?, id_alquiler=? "
                    + "where id_multa=?");
            
            smt.setDouble(1, updateRecord.getMonto_multa());
            smt.setDate(2, updateRecord.getFecha_vencimiento());
            smt.setInt(3, updateRecord.getEstado());
            smt.setInt(4, updateRecord.getIdC());
            smt.setInt(5, updateRecord.getIdAlquiler());
            smt.setInt(6, updateRecord.getId_multa());
                       
            smt.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en MultasDAO.update() "+e);
        }
        
    }

}
