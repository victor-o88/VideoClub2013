/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package datosPersona;

/**
 *
 * @author Alejandrux
 */
public abstract class Persona {

    //atributos
    private String cuil;  
    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer telefono;

//Constructores
    public Persona(){
        
    }
    
    public Persona(String cuil, String nombre, String apellido, String domicilio, Integer telefono) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    
    
    
    //getters and setters
    //dni
    public void setCuil(String cuil){
          this.cuil=cuil;
    }
    
    public String getCuil(){
        return cuil;
    }
    
    //nombre
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    //apellido
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    //domicilio
    public void setDomicilio(String domicilio){
        this.domicilio=domicilio;
    }
    
    public String getDomicilio(){
        return domicilio;
    }
    
    //telefono
    public void setTelefono(Integer telefono){
        this.telefono=telefono;
    }
    
    public Integer getTelefono(){
        return telefono;
    }
    
    

    //metodo abstracto
    public abstract void mostrarDatos();
            
    
    
    
    
    
    
}
