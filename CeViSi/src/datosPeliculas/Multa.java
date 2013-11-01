
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
    private Integer monto_multa;
    private Date fecha_vencimiento;
    //private Integer id_alquiler; //preguntar
    
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
    public Integer getMonto_multa() {
        return monto_multa;
    }

    public void setMonto_multa(Integer monto_multa) {
        this.monto_multa = monto_multa;
    }

    
    //fecha_vencimiento
    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    
}
