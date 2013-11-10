/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datosPeliculas.Peliculas;
//import datosPersona.Operador;
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
public class PeliculasDAO {

    
    //borrar
        public void delete(String cod_pelicula) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            smt.executeQuery("Delete from pelicula where cod_pelicula="+cod_pelicula);
            smt.close();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.delete() "+e);
        } 
    }

        
         //busqueda
    public Peliculas findByPK(String cod_pelicula) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            //no se que pasa che, fijate si lo podes resolver
            ResultSet result = smt.executeQuery("Select cod_pelicula, "
                    + "genero, titulo, formato, director, stock, monto "
                    + "from pelicula "
                    + "where cod_pelicula='"+cod_pelicula+"'");
            
            Peliculas peliculas = null;
            
            while(result.next()){
                peliculas = new Peliculas();
                
                peliculas.setCod_pelicula(result.getString("cod_pelicula"));
                peliculas.setGenero(result.getString("genero"));
                peliculas.setTitulo(result.getString("titulo"));
                peliculas.setFormato(result.getString("formato"));
                peliculas.setDirector(result.getString("director"));
                peliculas.setStock(result.getInt("stock"));
                peliculas.setMonto(result.getInt("monto"));
                
            }
            
            result.close();
            smt.close();
            return peliculas;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.findByPK "+e);
        }
    }
  
    
    
        //listar cuentas
    public Collection findAll() throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            Statement smt = con.createStatement();
            
            ResultSet result = smt.executeQuery("Select cod_pelicula as Codigo_Pelicula, "
                    + "genero as Genero, titulo as Titulo, "
                    + "formato as Formato, "
                    + "director as Director, stock as Stock, monto as Monto "
                    + "from pelicula "
                    + "order by cod_pelicula");
            
            Peliculas peliculas = null;
            ArrayList array = new ArrayList();
            
            while(result.next()){
                peliculas = new Peliculas();

                peliculas.setCod_pelicula(result.getString("Codigo_Pelicula"));
                peliculas.setGenero(result.getString("Genero"));
                peliculas.setTitulo(result.getString("Titulo"));
                peliculas.setFormato(result.getString("Formato"));
                peliculas.setDirector(result.getString("Director"));
                peliculas.setStock(result.getInt("Stock"));
                peliculas.setMonto(result.getInt("Monto"));

                array.add(peliculas);
            }
            
            result.close();
            smt.close();
            return array;
            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.findAll() "+e);
        }
    }

    
        //insertar registro
    public void insert (Peliculas insertRecord) throws DateAccessException{
        try {
            Peliculas existe = findByPK(insertRecord.getCod_pelicula());
            
            if(existe!=null){
                throw new DateAccessException("Cuenta existente en PeliculasDAO.insert() ");
            }
            
            Connection con = BaseDeDatos.getInstance();
            
            PreparedStatement smt = con.prepareStatement("Insert into pelicula "
                    + "(cod_pelicula, genero, titulo, formato, director, stock, monto) "
                    + "values (?,?,?,?,?,?,?)");
            smt.setString(1, insertRecord.getCod_pelicula());
            smt.setString(2, insertRecord.getGenero());
            smt.setString(3, insertRecord.getTitulo());
            smt.setString(4, insertRecord.getFormato());
            smt.setString(5, insertRecord.getDirector());
            smt.setInt(6, insertRecord.getStock());
            smt.setInt(7, insertRecord.getMonto());

            smt.execute();

            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.insert() "+e);
        } 
    }

    
        //modificar
    public void update(Peliculas updateRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement smt = con.prepareStatement("Update pelicula "
                    + "set formato=?, stock=?, genero=?, titulo=?, director=?, monto=? "
                    + "where cod_pelicula=?");
            
            smt.setString(1, updateRecord.getFormato());
            smt.setInt(2, updateRecord.getStock());
            smt.setString(3, updateRecord.getGenero());
            smt.setString(4, updateRecord.getTitulo());
            smt.setString(5, updateRecord.getDirector());
            smt.setInt(6, updateRecord.getMonto());
            smt.setString(7, updateRecord.getCod_pelicula());
            
            smt.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.update() "+e);
        }
    }

    
}


