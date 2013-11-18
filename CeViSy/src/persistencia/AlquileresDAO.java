/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datosPeliculas.Alquileres;
import datosPeliculas.Peliculas;
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
 * @author Alejandrux
 */
public class AlquileresDAO {
    
    //borrar
        public void delete(Integer id_alquiler) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            smt.executeQuery("Delete from alquileres where id_alquiler="+id_alquiler);
            smt.close();
            smt.executeQuery("Delete from alquiler_pelicula where id_alquiler="+id_alquiler);
            smt.close();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en AlquileresDAO.delete() "+e);
        } 
    }

        //busqueda
    public Alquileres findByPK(Integer id_alquiler) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select id_alquiler as Id_Alquiler, "
                    + "fecha_alquiler as Fecha_Alquiler, "
                    + "monto_alquiler as Monto_Alquiler, "
                    + "fecha_entrega as Fecha_Entrega, "
                    + "estado as Estado, id_cliente as Id_cliente "
                    + "from alquileres "
                    + "where id_alquiler='"+id_alquiler+"'");
            
            Alquileres alquiler = null;

            
            while(result.next()){
                alquiler = new Alquileres();
                
                alquiler.setId_alquiler(result.getInt("Id_Alquiler"));
                alquiler.setFecha_alquiler(result.getDate("Fecha_Alquiler"));
                alquiler.setMonto_alquiler(result.getInt("Monto_Alquiler"));
                alquiler.setFecha_entrega(result.getDate("Fecha_Entrega"));
                alquiler.setEstado(result.getInt("Estado"));
                alquiler.setId(result.getInt("Id_cliente"));
                
            }
            
            result.close();
            smt.close();
            return alquiler;
        } catch (Exception e) {
            throw new DateAccessException("Error en AlquileresDAO.findByPK "+e);
        }
    }

    
    //Peliculas alquiladas
    public Collection findByPKPelicula(Integer id_alquiler) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select alquileres.id_alquiler as Id_Alquiler, "
                    + "alquiler_pelicula.cod_pelicula as Codigo_Pelicula, "
                    + "pelicula.titulo as Titulo, persona.cuil as CUIL, "
                    + "persona.nombre as Nombre, persona.apellido as Apellido, "
                    + "alquileres.fecha_alquiler as Fecha_Alquiler, "
                    + "alquileres.monto_alquiler as Monto_Alquiler, "
                    + "alquileres.fecha_entrega as Fecha_Entrega "
                    + "from persona, alquileres, alquiler_pelicula, pelicula "
                    + "where persona.cuil=alquiler_pelicula.cuil and "
                    + "alquileres.id_alquiler = alquiler_pelicula.id_alquiler and "
                    + "pelicula.cod_pelicula = alquiler_pelicula.cod_pelicula and "
                    + "alquileres.id_alquiler="+id_alquiler);
            
            Alquileres alquiler = null;
            Peliculas pelicula = null;
            Cliente cliente = null;
            
            ArrayList array = new ArrayList();
            
            while(result.next()){
                pelicula = new Peliculas();
                
                pelicula.setCod_pelicula(result.getString("Codigo_Pelicula"));
                pelicula.setTitulo(result.getString("Titulo"));
                
                array.add(pelicula);
            }
            
            result.close();
            smt.close();
            return array;
        } catch (Exception e) {
            throw new DateAccessException("Error en AlquileresDAO.findByPK "+e);
        }
    }
    
    
    
    
    //listar alquileres
    public Collection findAll() throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select alquileres.id_alquiler as Id_Alquiler, "
                    /*+ "alquiler_pelicula.cod_pelicula as Codigo_Pelicula, "
                    + "pelicula.titulo as Titulo, persona.cuil as CUIL, "
                    + "persona.nombre as Nombre, persona.apellido as Apellido, "*/
                    + "alquileres.fecha_alquiler as Fecha_Alquiler, "
                    + "alquileres.monto_alquiler as Monto_Alquiler, "
                    + "alquileres.fecha_entrega as Fecha_Entrega, "
                    + "alquileres.estado as Estado, alquileres.id_cliente as Id_cliente "
                    /*+ "from persona, alquileres, alquiler_pelicula, pelicula "*/
                    + "from alquileres "
                    /*+ "where persona.cuil=alquiler_pelicula.cuil and "
                    + "alquileres.id_alquiler = alquiler_pelicula.id_alquiler and "
                    + "where alquileres.id_alquileres "
                    + "pelicula.cod_pelicula = alquiler_pelicula.cod_pelicula  "*/
                    + "order by alquileres.fecha_alquiler");
            
            Alquileres alquiler = null;
            
            ArrayList array = new ArrayList();
            
            while(result.next()){
                alquiler = new Alquileres();
                
                alquiler.setId_alquiler(result.getInt("Id_Alquiler"));
                alquiler.setFecha_alquiler(result.getDate("Fecha_Alquiler"));
                alquiler.setMonto_alquiler(result.getInt("Monto_Alquiler"));
                alquiler.setFecha_entrega(result.getDate("Fecha_Entrega"));
                alquiler.setEstado(result.getInt("Estado"));
                alquiler.setId(result.getInt("Id_cliente"));

                array.add(alquiler);
            }
            
            result.close();
            smt.close();
            return array;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en AlquileresDAO.findAll() "+e);
        }
    }
    
        //insertar registro
    public void insert (Alquileres insertRecord, Peliculas insertRecordPel1, Peliculas insertRecordPel2, Peliculas insertRecordPel3, Cliente insertRecord3) throws DateAccessException{
        try {
            Alquileres existe = findByPK(insertRecord.getId_alquiler());
                        
            if(existe!=null){
                throw new DateAccessException("Cuenta existente en AlquileresDAO.insert() ");
            }
            
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Insert into alquileres "
                    + "(id_alquiler, fecha_alquiler, monto_alquiler, fecha_entrega, estado, id_cliente) "
                    + "values (?,?,?,?,?,?)");
            smt.setInt(1, insertRecord.getId_alquiler());
            smt.setDate(2, insertRecord.getFecha_alquiler());
            smt.setInt(3, insertRecord.getMonto_alquiler());
            smt.setDate(4, insertRecord.getFecha_entrega());
            smt.setInt(5, insertRecord.getEstado());
            smt.setInt(6, insertRecord.getId());

            
            PreparedStatement smt2 = con.prepareStatement("Insert into alquiler_pelicula "
                    + "(cod_pelicula, cuil, id_alquiler) "
                    + "values (?,?,?)");

            smt2.setString(1, insertRecordPel1.getCod_pelicula());
            smt2.setString(2, insertRecord3.getCuil());
            smt2.setInt(3, insertRecord.getId_alquiler());

            PreparedStatement smt3 = con.prepareStatement("Insert into alquiler_pelicula "
                    + "(cod_pelicula, cuil, id_alquiler) "
                    + "values (?,?,?)");

            smt3.setString(1, insertRecordPel2.getCod_pelicula());
            smt3.setString(2, insertRecord3.getCuil());
            smt3.setInt(3, insertRecord.getId_alquiler());

            PreparedStatement smt4 = con.prepareStatement("Insert into alquiler_pelicula "
                    + "(cod_pelicula, cuil, id_alquiler) "
                    + "values (?,?,?)");

            smt4.setString(1, insertRecordPel3.getCod_pelicula());
            smt4.setString(2, insertRecord3.getCuil());
            smt4.setInt(3, insertRecord.getId_alquiler());
            
            
            smt.execute();
            smt2.execute();
            smt3.execute();
            smt4.execute();
        } catch (Exception e) {
            throw new DateAccessException("Error en AlquileresDAO.insert() "+e);
        } 
    }

        //devolucion o multa
    public void update(Alquileres updateRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Update alquileres "
                    + "set fecha_alquiler=?, monto_alquiler=?, "
                    + "fecha_entrega=?, estado=?, id_cliente=?"
                    + "where id_alquiler=?");
            
            smt.setDate(1, updateRecord.getFecha_alquiler());
            smt.setInt(2, updateRecord.getMonto_alquiler());
            smt.setDate(3, updateRecord.getFecha_entrega());
            smt.setInt(4, updateRecord.getEstado());
            smt.setInt(5, updateRecord.getId());
            smt.setInt(6, updateRecord.getId_alquiler());
            
            smt.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en ALquileresDAO.update() "+e);
        }
        
    }
    
    
    

}
