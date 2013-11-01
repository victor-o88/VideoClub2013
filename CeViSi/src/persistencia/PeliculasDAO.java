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
            
            ResultSet result = smt.executeQuery("Select cod_pelicula as Código_Película, "
                    + "genero as Género, titulo as Título, "
                    + "formato as Formato, director as Director, "
                    + "stock as Stock "
                    + "from pelicula "
                    + "where cod_pelicula='"+cod_pelicula+"'");
            
            Peliculas peliculas = null;
            
            while(result.next()){
                peliculas = new Peliculas();
                
                peliculas.setCod_pelicula(result.getString("Código_Película"));
                peliculas.setGenero(result.getString("Género"));
                peliculas.setTitulo(result.getString("Título"));
                peliculas.setFormato(result.getString("Formato"));
                peliculas.setDirector(result.getString("Director"));
                peliculas.setStock(result.getInt("Stock"));
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
                    + "director as Director, stock as Stock  "
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
                    + "(cod_pelicula, genero, titulo, formato, director, stock) "
                    + "values (?,?,?,?,?,?)");
            smt.setString(1, insertRecord.getCod_pelicula());
            smt.setString(2, insertRecord.getGenero());
            smt.setString(3, insertRecord.getTitulo());
            smt.setString(4, insertRecord.getFormato());
            smt.setString(5, insertRecord.getDirector());
            smt.setInt(6, insertRecord.getStock());
            
            
            smt.execute();

            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.insert() "+e);
        } 
    }

    
        //modificar
    public void update(Peliculas insertRecord) throws DateAccessException{
        try {
            Connection con = BaseDeDatos.getInstance();
            PreparedStatement smt = con.prepareStatement("Update pelicula "
                    + "set formato=?, stock=?"
                    + "where cod_pelicula=?");
            
            smt.setString(1, insertRecord.getFormato());
            smt.setInt(2, insertRecord.getStock());
            
            smt.execute();
            
        } catch (Exception e) {
            throw new DateAccessException("Error en PeliculasDAO.update() "+e);
        }
    }

    
}


