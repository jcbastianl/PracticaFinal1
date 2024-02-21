/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exception.VerticeException;
import controlador.TDAListas.DynamicList;
import controlador.Utiles.Utiles;

/**
 *
 * @author mrbingus
 */
public class GrafoNoDirigido extends Grafo {

    private Integer num_vertice;
    private Integer num_aristas;
    private DynamicList<Adyacencia> listaAdyacencias[];

    public GrafoNoDirigido(Integer num_vertices) {
        this.num_vertice = num_vertices;
        this.num_aristas = 0;
        this.listaAdyacencias = new DynamicList[num_vertices + 1];
        for (int i = 0; i <= this.num_vertice; i++) {
            listaAdyacencias[i] = new DynamicList<>();
        }
    }

    @Override
    public Integer num_vertice() {
        return num_vertice;
    }

    @Override
    public Integer num_aristas() {
        return num_aristas;
    }

    @Override
    public Boolean existe_arista(Integer v1, Integer v2) throws Exception {
        Boolean band = false;
        if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
            DynamicList<Adyacencia> listaA = listaAdyacencias[v1];
            for (int i = 0; i < listaA.getLenght(); i++) {
                Adyacencia a = listaA.getInfo(i);
                if (a.getDestino().intValue() == v2.intValue()) {
                    band = true;
                    break;
                }
            }
        } else {
            throw new VerticeException();
        }
        return band;
    }

    @Override
    public Double peso_arista(Integer v1, Integer v2) throws Exception {
        Double peso = Double.NaN;
        if (existe_arista(v1, v2)) {
            DynamicList<Adyacencia> listaA = listaAdyacencias[v1];
            for (int i = 0; i < listaA.getLenght(); i++) {
                Adyacencia a = listaA.getInfo(i);
                if (a.getDestino().intValue() == v2.intValue()) {
                    peso = a.getPeso();
                    break;
                }
            }
        }
        return peso;
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception {
        if (v1.intValue() <= num_vertice && v2.intValue() <= num_vertice) {
            if (!existe_arista(v1, v2)) {
                num_aristas++;
                listaAdyacencias[v1].add(new Adyacencia(v2, peso));
                listaAdyacencias[v2].add(new Adyacencia(v1, peso));
            }
        } else {
            throw new VerticeException();
        }
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2) throws Exception {

    }

    @Override
    public DynamicList<Adyacencia> adyacentes(Integer v1) {
        return listaAdyacencias[v1];
    }

    public static void main(String[] args) throws VerticeException {
        Grafo f = new GrafoNoDirigido(15);
        System.out.println(f);
        try {
            f.insertar_arista(1, 2, 1.0);
            f.insertar_arista(2, 3, 1.0);
            f.insertar_arista(3, 4, 1.0);
            f.insertar_arista(4, 6, 1.0);
            f.insertar_arista(6, 7, 1.0);
            f.insertar_arista(7, 8, 1.0);
            f.insertar_arista(8, 9, 1.0);
            f.insertar_arista(9, 10, 1.0);
            f.insertar_arista(10, 6, 50.0);
            f.insertar_arista(1, 6, 50.0);
            f.insertar_arista(7, 4, 50.0);
            f.insertar_arista(7, 11, 50.0);
            f.insertar_arista(4, 12, 50.0);

            System.out.println(f);

            PaintGraph p = new PaintGraph();
            p.updateFileNormal(f);
            System.out.println(Utiles.getOS());
//            Utiles.abrirNavegadorPredeterminadorWindows("d3/grafo.html");
        } catch (Exception e) {
            throw new VerticeException();
        }
        System.out.println(f.num_aristas());
    }

}
