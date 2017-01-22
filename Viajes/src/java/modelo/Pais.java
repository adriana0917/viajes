
package modelo;

/**
 *
 * @author Adriana
 */
public class Pais {
    private int codPais;
    private String nombre;
    
    public Pais(){
        
    }

    public Pais(int codPais, String nombre) {
        this.codPais = codPais;
        this.nombre = nombre;
    }

    public int getCodPais() {
        return codPais;
    }

    public void setCodPais(int codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }       
    
}
