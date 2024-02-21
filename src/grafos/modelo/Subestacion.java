/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.modelo;

/**
 *
 * @author mrbingus
 */
public class Subestacion {
    private Integer id;
    private String nombre;
    private String lugar;
    private String logo;
    
    private Coordenadas coordenadas;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the escudo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the escudo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the coordenadas
     */
    public Coordenadas getCoordenadas() {
        if(coordenadas == null){
            coordenadas = new Coordenadas();
        }
        return coordenadas;
    }

    /**
     * @param coordenadas the coordenadas to set
     */
    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
