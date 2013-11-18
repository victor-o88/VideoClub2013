
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPeliculas;

import java.sql.Date;

/**
 *
 * @author Alejandrux
 */
public class Multa {
    
    //atributos
    private Integer id_multa;
    private Double monto_multa;
    private Date fecha_vencimiento;
    private Integer estado;
    private Integer id_cliente;
    private Integer id_alquiler; //preguntar
    
    public Multa(){
        
    }

    
    //getters and setters
    //Id_multa
    public Integer getId_multa() {
        return id_multa;
    }
    public void setId_multa(Integer id_multa) {
        this.id_multa = id_multa;
    }

    //monto_multa
    public Double getMonto_multa() {
        return monto_multa;
    }
    public void setMonto_multa(Double monto_multa) {
        this.monto_multa = monto_multa;
    }

    
    //fecha_vencimiento
    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }
    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    public Integer getEstado(){
        return estado;
    }
    public void setEstado(Integer estado){
        this.estado = estado;
    }
    
    public Integer getIdC(){
        return id_cliente;
    }
    public void setIdC(Integer id_cliente){
        this.id_cliente = id_cliente;
    }
    
    public Integer getIdAlquiler(){
        return id_alquiler;
    }
    public void setIdAlquiler(Integer id_alquiler){
        this.id_alquiler = id_alquiler;
    }
    
    
    public Multa(Integer id_multa, Double monto_multa, Date fecha_vencimiento, Integer estado, Integer id_cliente, Integer id_alquiler) {
        this.id_multa = id_multa;
        this.monto_multa = monto_multa;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
        this.id_cliente = id_cliente;
        this.id_alquiler = id_alquiler;
    }
    
    
}
