/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafosEjemplo;

import controlador.DAO.DaoImplement;
import controlador.TDA.grafos.GrafoDirigido;
import controlador.TDA.grafos.GrafoEtiquetadoNoDirigido;
import controlador.TDAListas.DynamicList;
import grafos.modelo.Subestacion;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mrbingus
 */
public class EscuelaDao extends DaoImplement<Subestacion> {

    private DynamicList<Subestacion> lista = new DynamicList<>();
    private Subestacion escuela;
    private GrafoEtiquetadoNoDirigido<Subestacion> grafo;

    public EscuelaDao() {
        super(Subestacion.class);
    }

    /**
     * @return the lista
     */
    public DynamicList<Subestacion> getLista() {
        if (lista.isEmpty()) {
            lista = all();

        }
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DynamicList<Subestacion> lista) {
        this.lista = lista;
    }

    /**
     * @return the escuela
     */
    public Subestacion getEscuela() {
        if (escuela == null) {
            escuela = new Subestacion();
        }
        return escuela;
    }

    /**
     * @param escuela the escuela to set
     */
    public void setEscuela(Subestacion escuela) {
        this.escuela = escuela;
    }

    public Boolean persist() {
        escuela.setId(all().getLenght() + 1);
        return persist(escuela);
    }

    public GrafoEtiquetadoNoDirigido<Subestacion> getGrafo() throws Exception {
        if (grafo == null) {
            if (!lista.isEmpty()) {

            }
            grafo = new GrafoEtiquetadoNoDirigido<>(getLista().getLenght(), Subestacion.class);
            for (int i = 0; i < grafo.num_vertice(); i++) {
                grafo.labelVertice(i + 1, getLista().getInfo(i));
            }
        }
        return grafo;
    }

    public void guardarGrafo() throws Exception {
        getConection().toXML(grafo, new FileWriter("files/grafo.json"));

    }

    public void loadGraph() throws Exception {
    grafo = (GrafoEtiquetadoNoDirigido<Subestacion>)getConection().fromXML(new FileReader("files/grafo.json"));
    lista.reset();
        for (int i = 0; i <= grafo.getNum_vertice(); i++) {
            lista.add((Subestacion)grafo.getLabelE(i));
        }
        
    }
    

    
}
