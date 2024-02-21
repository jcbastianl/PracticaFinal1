/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.grafoEjemplo.tablas;

import controlador.Exception.EmptyException;
import controlador.TDA.grafos.GrafoEtiquetadoDirigido;
import controlador.TDAListas.DynamicList;
import controlador.Utiles.Utiles;
import grafos.modelo.Subestacion;
import java.net.SocketOptions;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mrbingus
 */
public class ModeloTablaAdyacenciasEscuela extends AbstractTableModel{

    private GrafoEtiquetadoDirigido<Subestacion> grafo;

   @Override
    public int getRowCount() {
        return getGrafo().getNum_vertice();
    }

    @Override
    public int getColumnCount() {
        return getGrafo().getNum_vertice()+1;
    }

@Override
        public Object getValueAt(int i, int il) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                try {
                        if(il == 0){
                                return grafo.getLabelE(i + 1).toString();
                        } else {
                                Subestacion o = grafo.getLabelE(i + 1);
                                Subestacion d = grafo.getLabelE(il);
                                if(grafo.isEdgeE(o, d)){
                                        return Utiles.redonder(grafo.peso_arista(i+1, il));
                                }
                        }
                } catch (Exception e) {
                }
                return null;
        }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ESCUELAS";
        } else {
            try {
            return getGrafo().getLabelE(column).toString();                
            } catch (Exception e) {
                return "";
            }

        }

    }
        
    
    
    /**
     * @return the grafo
     */
    public GrafoEtiquetadoDirigido getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(GrafoEtiquetadoDirigido grafo) {
        this.grafo = grafo;
    }
    
    
}
