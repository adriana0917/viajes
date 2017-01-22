/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Adriana
 */
public class Aerolinea {
    private int codAerolinea;
    private String nombre;
    
    public Aerolinea(){
        
    }

    public Aerolinea(int codAerolinea, String nombre) {
        this.codAerolinea = codAerolinea;
        this.nombre = nombre;
    }

    public int getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(int codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
          
}
