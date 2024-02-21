/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exception.LabelEdgeException;
import controlador.TDA.grafos.exception.VerticeException;
import controlador.TDAListas.DynamicList;
import java.lang.reflect.Array;
import java.util.HashMap;

/**
 *
 * @author mrbingus
 */
public class GrafoEtiquetadoDirigido<E> extends GrafoDirigido {

    protected E[] labels;
    // ---> labels 1;
    // ---> labels 2;
    protected HashMap<E, Integer> dirVertices;
    private Class<E> clazz;

    public GrafoEtiquetadoDirigido(Integer num_vertices, Class clazz) {
        super(num_vertices);
        this.clazz = clazz;
        labels = (E[]) Array.newInstance(clazz, num_vertices + 1);
        dirVertices = new HashMap<>(num_vertices);
    }

    /*
    
     */
    public Integer getVerticeE(E label) throws Exception {
        Integer aux = dirVertices.get(label);
        if (aux != null) {
            return dirVertices.get(label);
        } else {
            throw new VerticeException("No se encuentra vertice");
        }
    }

    public E getLabelE(Integer v) throws Exception {
        if (v <= num_vertice()) {
            return labels[v];
        } else {
            throw new VerticeException("No se encuentra vertice");
        }
    }

    public Boolean isEdgeE(E o, E d) throws Exception {
        if (isAllLabelsGraph()) {
            return existe_arista(getVerticeE(o), getVerticeE(d));
        } else {
            throw new LabelEdgeException();
        }
    }

    public void insertEdgeE(E o, E d, Double weight) throws Exception {
        if (isAllLabelsGraph()) {
            insertar_arista(getVerticeE(o), getVerticeE(d), weight);
        } else {
            throw new LabelEdgeException();
        }
    }

    public DynamicList<Adyacencia> adjacents(E label) throws Exception {
        if (isAllLabelsGraph()) {
            return adyacentes(getVerticeE(label));
        } else {
            throw new LabelEdgeException();
        }
    }

    public void labelVertice(Integer v, E label) {
        labels[v] = label;
        dirVertices.put(label, v);
    }

    public Boolean isAllLabelsGraph() {
        Boolean band = true;
        for (int i = 1; i < labels.length; i++) {
            if (labels[i] == null) {
                band = false;
                break;
            }
        }
        return band;
    }

    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder("GRAFO").append("\n");
        try {
            for (int i = 1; i <= num_vertice(); i++) {
                grafo.append("[").append(i).append("] = ").append(getLabelE(i)).append("\n");
                DynamicList<Adyacencia> list = adyacentes(i);
                for (int j = 0; j < list.getLenght(); j++) {
                    Adyacencia a = list.getInfo(j);
                    grafo.append("ady [").append(a.getDestino()).append("]").append(getLabelE(a.getDestino())).append(" peso ").append(a.getPeso()).append("\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return grafo.toString();
    }

    public static void main(String[] args) {
        try {
            GrafoEtiquetadoDirigido<String> ged = new GrafoEtiquetadoDirigido(4, String.class);
            ged.labelVertice(1, "nodito");
            ged.labelVertice(2, "nodito2");
            ged.labelVertice(3, "edqin");
            ged.labelVertice(4, "juan");
            ged.insertEdgeE("nodito", "edqin", 53.0);
            ged.insertEdgeE("juan", "edqin", 53.0);
            System.out.println(ged.toString());
            PaintGraph p = new PaintGraph();
            p.updateFileEtiquetado(ged);
        } catch (Exception e) {
        }
    }
}
