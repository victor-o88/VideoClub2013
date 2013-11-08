/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPeliculas;

/**
 *
 * @author Alejandrux
 */
public class Peliculas {
    //atributos
    private String cod_pelicula;
    private String genero;
    private String titulo;
    private String formato;
    private String director;
    private Integer stock;
    private Integer monto;
    
    //constructores
    public Peliculas(){
        
    }

    public Peliculas(String cod_pelicula) {
        this.cod_pelicula = cod_pelicula;
    }

    
    public Peliculas(String cod_pelicula, String genero, String titulo, String formato, String director, Integer stock, Integer monto) {
        this.cod_pelicula = cod_pelicula;
        this.genero = genero;
        this.titulo = titulo;
        this.formato = formato;
        this.director = director;
        this.stock = stock;
        this.monto = monto;
    }
    
    //

    //getters and setters
    //cod_pelicula
    public String getCod_pelicula() {
        return cod_pelicula;
    }

    public void setCod_pelicula(String cod_pelicula) {
        this.cod_pelicula = cod_pelicula;
    }

    //genero
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    //titulo
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //formato
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    //autor
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //stock
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    //monto
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    
    
}
