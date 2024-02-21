/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.modelo;

/**
 *
 * @author mrbingus
 */
public class Coordenadas {
    private Integer id;
    private Double longitud;
    private Double latitud;

    public Coordenadas() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the amplitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param amplitud the amplitud to set
     */
    public void setLatiitud(Double amplitud) {
        this.latitud = amplitud;
    }

    @Override
    public String toString() {
        return "lon:" +longitud+" ; lat:"+latitud+"";
    }
    
    
    
}
