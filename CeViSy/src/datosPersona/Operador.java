
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPersona;

/**
 *
 * @author Alejandrux
 */
public class Operador extends Persona{
    //atributos
    private Integer id_operador;
    private String contraseña;
    private String conf_contraseña;
    
    //contrctores
    public Operador(){
        
    }

    public Operador(Integer id_operador) {
        this.id_operador = id_operador;
    }

    public Operador(Integer id_operador, String contraseña, String conf_contraseña) {
        this.id_operador = id_operador;
        this.contraseña = contraseña;
        this.conf_contraseña = conf_contraseña;
    }
    
    

    public Operador(Integer id_operador, String cuil, String nombre, String apellido, String domicilio, Integer telefono,String contraseña) {
        super(cuil, nombre, apellido, domicilio, telefono);
        this.id_operador = id_operador;
        this.contraseña= contraseña;
    }
    
    
    //getters and setters
    //id_operador
    public void setIdOperador(Integer id_operador){
        this.id_operador=id_operador;
    }
    
    public Integer getIdOperador(){
        return id_operador;
    }
    
    //contraseña
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    //reingresar contraseña
    public String getConf_contraseña() {
        return conf_contraseña;
    }

    public void setConf_contraseña(String conf_contraseña) {
        this.conf_contraseña = conf_contraseña;
    }
    
    
    
    @Override
    public void mostrarDatos(){
        
    }
    
    
}
