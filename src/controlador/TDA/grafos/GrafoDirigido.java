/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.grafos;

import controlador.TDA.grafos.exception.VerticeException;
import controlador.TDAListas.DynamicList;


/**
 *
 * @author mrbingus
 */
public class GrafoDirigido extends Grafo {

    private Integer num_vertice;
    private Integer num_aristas;
    private DynamicList<Adyacencia> listaAdyacencias[];

    public GrafoDirigido(Integer num_vertices) {
        this.num_vertice = num_vertices;
        this.num_aristas = 0;
        this.listaAdyacencias = new DynamicList[num_vertices + 1];
        for (int i = 0; i <= this.num_vertice; i++) {
            listaAdyacencias[i] = new DynamicList<>();
        }
    }

    @Override
    public Integer num_vertice() {
        return getNum_vertice();
    }

    @Override
    public Integer num_aristas() {
        return getNum_aristas();
    }

    @Override
    public Boolean existe_arista(Integer v1, Integer v2) throws Exception {
        Boolean band = false;
        if (v1.intValue() <= getNum_vertice() && v2.intValue() <= getNum_vertice()) {
            DynamicList<Adyacencia> listaA = getListaAdyacencias()[v1];
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
            DynamicList<Adyacencia> listaA = getListaAdyacencias()[v1];
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
    public void insertar_arista(Integer v1, Integer v2, Double peso) throws Exception{
        if (v1.intValue() <= getNum_vertice() && v2.intValue() <= getNum_vertice()) {
            if (!existe_arista(v1, v2)) {
                num_aristas++;
                getListaAdyacencias()[v1].add(new Adyacencia(v2, peso));
            }
        }else
            throw new VerticeException();
    }

    @Override
    public void insertar_arista(Integer v1, Integer v2) throws Exception{
        insertar_arista(v1, v2, Double.NaN);
    }

    @Override
    public DynamicList<Adyacencia> adyacentes(Integer v1) {
        return getListaAdyacencias()[v1];
    }
    
    public static void main(String[] args) throws VerticeException {
        Grafo f = new GrafoDirigido(6);
        System.out.println(f);
        try {
            f.insertar_arista(1, 3, 50.0);
            f.insertar_arista(4, 5, 10.0);
            System.out.println(f);
        } catch (Exception e) {
            throw new VerticeException();
        }
    }

    /**
     * @return the num_vertice
     */
    public Integer getNum_vertice() {
        return num_vertice;
    }

    /**
     * @return the num_aristas
     */
    public Integer getNum_aristas() {
        return num_aristas;
    }

    /**
     * @return the listaAdyacencias
     */
    public DynamicList<Adyacencia>[] getListaAdyacencias() {
        return listaAdyacencias;
    }

    /**
     * @param num_vertice the num_vertice to set
     */
    public void setNum_vertice(Integer num_vertice) {
        this.num_vertice = num_vertice;
    }

    /**
     * @param num_aristas the num_aristas to set
     */
    
    public void setNum_aristas(Integer num_aristas) {
        this.num_aristas = num_aristas;
    }

    /**
     * @param listaAdyacencias the listaAdyacencias to set
     */
    public void setListaAdyacencias(DynamicList<Adyacencia>[] listaAdyacencias) {
        this.listaAdyacencias = listaAdyacencias;
    }
     public DynamicList<Double> bellmanFord(Integer origen) throws Exception {
        DynamicList<Double> distancia = new DynamicList<>();
        for (int i = 0; i <= num_vertice; i++) {
            distancia.add(Double.POSITIVE_INFINITY);
        }
        distancia.set(origen, 0.0);

       
        for (int i = 1; i <= num_vertice - 1; i++) {
            for (int u = 1; u <= num_vertice; u++) {
                DynamicList<Adyacencia> adyacentesU = adyacentes(u);
                for (int j = 0; j < adyacentesU.getLenght(); j++) {
                    Adyacencia adyacente = adyacentesU.getInfo(j);
                    Integer v = adyacente.getDestino();
                    Double pesoUV = adyacente.getPeso();
                    if (distancia.get(u) + pesoUV < distancia.get(v)) {
                        distancia.set(v, distancia.get(u) + pesoUV);
                    }
                }
            }
        }

        
        for (int u = 1; u <= num_vertice; u++) {
            DynamicList<Adyacencia> adyacentesU = adyacentes(u);
            for (int j = 0; j < adyacentesU.getLenght(); j++) {
                Adyacencia adyacente = adyacentesU.getInfo(j);
                Integer v = adyacente.getDestino();
                Double pesoUV = adyacente.getPeso();
                if (distancia.get(u) + pesoUV < distancia.get(v)) {
                    throw new Exception("El grafo contiene un ciclo de peso negativo");
                }
            }
        }

        return distancia;
    }
     
    public DynamicList<DynamicList<Double>> floydWarshall() throws Exception {
        DynamicList<DynamicList<Double>> distancias = new DynamicList<>();
        
        // Inicializar matriz de distancias
        for (int i = 0; i <= num_vertice; i++) {
            DynamicList<Double> fila = new DynamicList<>();
            for (int j = 0; j <= num_vertice; j++) {
                if (i == j) {
                    fila.add(0.0); // Distancia de un vértice a sí mismo es 0
                } else {
                    fila.add(Double.POSITIVE_INFINITY); // Inicializar con infinito
                }
            }
            distancias.add(fila);
        }

        // Llenar la matriz con los pesos de las aristas existentes
        for (int u = 1; u <= num_vertice; u++) {
            DynamicList<Adyacencia> adyacentesU = adyacentes(u);
            for (int j = 0; j < adyacentesU.getLenght(); j++) {
                Adyacencia adyacente = adyacentesU.getInfo(j);
                Integer v = adyacente.getDestino();
                Double pesoUV = adyacente.getPeso();
                distancias.get(u).set(v, pesoUV);
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 1; k <= num_vertice; k++) {
            for (int i = 1; i <= num_vertice; i++) {
                for (int j = 1; j <= num_vertice; j++) {
                    if (distancias.get(i).get(k) + distancias.get(k).get(j) < distancias.get(i).get(j)) {
                        distancias.get(i).set(j, distancias.get(i).get(k) + distancias.get(k).get(j));
                    }
                }
            }
        }

        // Verificar ciclos de peso negativo
        for (int i = 1; i <= num_vertice; i++) {
            if (distancias.get(i).get(i) < 0) {
                throw new Exception("El grafo contiene un ciclo de peso negativo");
            }
        }

        return distancias;
    }
}
