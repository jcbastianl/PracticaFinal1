package controlador.TDA.grafos;

import controlador.TDAListas.DynamicList;
import java.io.FileWriter;

/**
 *
 * @author mrbingus
 */
public class PaintGraph {

    String URL = "d3/grafo.js";
    StringBuilder StringVertices = new StringBuilder();
    StringBuilder StringAristas = new StringBuilder();

    public void updateFileNormal(Grafo graph) throws Exception {

        for (int i = 1; i <= graph.num_vertice(); i++) {
            StringVertices.append("{ id: ").append(i).append(", label: \"Node ").append(i).append("\" },\n");

            DynamicList<Adyacencia> listaAdyacencia = graph.adyacentes(i);

            for (int j = 0; j < listaAdyacencia.getLenght(); j++) {

                Adyacencia a = listaAdyacencia.getInfo(j);

                StringAristas.append("{ from: ").append(i)
                        .append(", to: ").append(a.getDestino())
                        .append(", label: \"").append(a.getPeso()).append("\" },\n");
            }
        }
        dibujarCola();

    }

    public void updateFileEtiquetado(GrafoEtiquetadoDirigido graph) {
        try {
            for (int i = 1; i <= graph.num_vertice(); i++) {
                StringVertices.append("{ id: ").append(i).append(", label: \"" + graph.getLabelE(i)).append("\" },\n");

                DynamicList<Adyacencia> listaAdyacencia = graph.adyacentes(i);

                for (int j = 0; j < listaAdyacencia.getLenght(); j++) {

                    Adyacencia a = listaAdyacencia.getInfo(j);

                    StringAristas.append("{ from: ").append(i)
                            .append(", to: ").append(a.getDestino())
                            .append(", label: \"").append(a.getPeso()).append("\" },\n");
                }
                dibujarCola();
            }
        } catch (Exception e) {
        }

    }

    public void dibujarCola() {
        String paint = "var nodes = new vis.DataSet([\n" + StringVertices.toString() + "]);\n\n"
                + "var edges = new vis.DataSet([\n" + StringAristas.toString() + "]);\n\n"
                + "var container = document.getElementById(\"mynetwork\");\n"
                + "var data = {\n"
                + "  nodes: nodes,\n"
                + "  edges: edges,\n"
                + "};\n"
                + "var options = {};\n"
                + "var network = new vis.Network(container, data, options);";

        try {
            FileWriter load = new FileWriter(URL);
            load.write(paint);
            load.close();
        } catch (Exception e) {
        }

    }
}
