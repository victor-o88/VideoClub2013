/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersona;

import interfaces.IAlquiler;
import java.sql.Date;

/**
 *
 * @author Alejandrux
 */
public class Cliente extends Persona {
    
    //atributos
    private Integer id_cliente;
    private Date fecha_inscripcion;
    //private boolean estado;
    private Date fecha_baja;
    private String motivo_baja;
    
    //constructores
    public Cliente(){
    }

    public Cliente(String cuil) {
        super(cuil);
    }
    
    
    
    public Cliente(Integer id_cliente){
        this.id_cliente = id_cliente;
    }

    public Cliente(Integer id_cliente, String cuil, String nombre, String apellido, String domicilio, Integer telefono) {
        super(cuil, nombre, apellido, domicilio, telefono);
        this.id_cliente = id_cliente;
    }
    
    
    
    public Cliente(Integer id_cliente, Date fecha_inscripcion, String cuil, String nombre, String apellido, String domicilio, Integer telefono) {
        super(cuil, nombre, apellido, domicilio, telefono);
        this.id_cliente = id_cliente;
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    
    
    //getters and setters
    //id_socio
    public void setIdCliente(Integer id_cliente){
        this.id_cliente=id_cliente;
    }
    
    public Integer getIdCliente(){
        return id_cliente;
    }
    
    
    //fecha_inscripcion
    public void setFechaInscripcion(Date fecha_inscripcion){
        this.fecha_inscripcion=fecha_inscripcion;
    }
    
    public Date getFechaInscripcion(){
        return fecha_inscripcion;
    }
    
    //fecha de baja
    public void setFechabaja(Date fecha_baja){
        this.fecha_baja=fecha_baja;
    }
    
    public Date getFechabaja(){
        return fecha_baja;
    }
    
    //motivo de baja
    public void setMotivobaja(String motivo_baja){
        this.motivo_baja=motivo_baja;
    }
    
    public String getMotivobaja(){
        return motivo_baja;
    }
    
    @Override
    public void mostrarDatos(){
        
    }

    
    
    
    
}
