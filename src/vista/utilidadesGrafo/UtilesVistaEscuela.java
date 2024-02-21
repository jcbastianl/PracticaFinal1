/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidadesGrafo;

import controlador.TDA.grafos.GrafoEtiquetadoDirigido;
import controlador.TDAListas.DynamicList;
import controlador.Utiles.Utiles;
import controlador.grafosEjemplo.EscuelaDao;
import grafos.modelo.Subestacion;
import java.io.FileWriter;
import javax.swing.JComboBox;

/**
 *
 * @author mrbingus
 */
public class UtilesVistaEscuela {

public static void crearMapaEscuela(GrafoEtiquetadoDirigido<Subestacion> ge) throws Exception {
                String maps = "var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',\n"
                        + "        osmAttrib = '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n"
                        + "        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});\n"
                        + "\n"
                        + "var map = L.map('map').setView([-4.036, -79.201], 15);\n"
                        + "\n"
                        + "L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                        + "    attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                        + "}).addTo(map);";
                for (int i = 1; i <= ge.num_vertice(); i++) {
                        Subestacion ec = ge.getLabelE(i);
                        maps += "L.marker([" + ec.getCoordenadas().getLongitud() + ", " + ec.getCoordenadas().getLatitud()+ "]).addTo(map)" + "\n";
                        maps += ".bindPopup('" + ec.getNombre() + ".')" + "\n";
                        maps += ".openPopup();" + "\n";
                }
                FileWriter file = new FileWriter("mapas/mapa.js");
                file.write(maps);
                file.close();
        }

    public static void cargarComboEscuela(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        DynamicList<Subestacion> escuelas = new EscuelaDao().getLista();
        for (int i = 0; i < escuelas.getLenght(); i++) {
            cbx.addItem(escuelas.getInfo(i));
        }
    }

    public static Double calcularDistanciaEscuelas(Subestacion or, Subestacion de) {
        Double dist = Utiles.coordGpsToKm(or.getCoordenadas().getLatitud(),
                or.getCoordenadas().getLongitud(),
                de.getCoordenadas().getLatitud(),
                de.getCoordenadas().getLongitud());
        return dist;
    }
}
