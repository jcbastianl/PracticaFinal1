/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exception.VerticeException;

/**
 *
 * @author mrbingus
 */
public class GrafoEtiquetadoNoDirigido<E> extends GrafoEtiquetadoDirigido {

    public GrafoEtiquetadoNoDirigido(Integer num_vertices, Class clazz) {
        super(num_vertices, clazz);
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (v1.intValue() <= num_vertice() && v2.intValue() <= num_vertice()) {
            if (!existe_arista(v1, v2)) {
                setNum_aristas(num_aristas() + 1);
                getListaAdyacencias()[v1].add(new Adyacencia(v2, peso));
                getListaAdyacencias()[v2].add(new Adyacencia(v1, peso));
                //num_aristas++;                
                //listaAdycencias[v1].add(new Adycencia(v2, peso));
            }
        } else {
            throw new VerticeException();
        }
    }

    public static void main(String[] args) {
        try {
            GrafoEtiquetadoNoDirigido<String> ged = new GrafoEtiquetadoNoDirigido(6, String.class);
            ged.labelVertice(1, "Coso1");
            ged.labelVertice(2, "tomate");
            ged.labelVertice(3, "Coso3");
            ged.labelVertice(4, "Coso4");
            ged.labelVertice(5, "Coso5");
            ged.labelVertice(6, "Coso6");
            ged.insertEdgeE("Coso1", "tomate", 50.0);
            System.out.println(ged.toString());
            PaintGraph p = new PaintGraph();
            p.updateFileEtiquetado(ged);
        } catch (Exception e) {
        }
    }

}
