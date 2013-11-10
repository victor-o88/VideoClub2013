/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPeliculas;

import datosPersona.Cliente;
import gestionar.GestorClientes;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Alejandrux
 */
public class Alquileres {
    private Integer id_alquiler;
    private GestorClientes cliente;
    private Date fecha_alquiler;
    private Date fecha_entrega;
    private Integer monto_alquiler;
    //private ArrayList<Peliculas> peliculas = new ArrayList();

    
    
    //getters and setters
    //id_alquiler
    public Integer getId_alquiler() {
        return id_alquiler;
    }

    public Alquileres(Integer id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    
    
    public void setId_alquiler(Integer id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    //cliente
    public GestorClientes getCliente() {
        return cliente;
    }

    public void setCliente(GestorClientes cliente) {
        this.cliente = cliente;
    }

    //peliculas
    /*public ArrayList getPelicula() {
        return peliculas;
    }

    public void setPelicula(ArrayList peliculas) {
        this.peliculas = peliculas;
    }**/

    //fecha_alquiler
    public Date getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(Date fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    //fecha_entrega
    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    //monto
    public Integer getMonto_alquiler() {
        return monto_alquiler;
    }

    public void setMonto_alquiler(Integer monto_alquiler) {
        this.monto_alquiler = monto_alquiler;
    }
    
    //constructores
    public Alquileres() {
    }

    public Alquileres(Integer id_alquiler, GestorClientes cliente, Date fecha_alquiler, Integer monto_alquiler, Date fecha_entrega) {
        this.id_alquiler = id_alquiler;
        this.cliente = cliente;
        this.fecha_alquiler = fecha_alquiler;
        this.monto_alquiler = monto_alquiler;
        this.fecha_entrega = fecha_entrega;
    }

    public void limitarAlquiler(ArrayList pel){
        
    }
}
