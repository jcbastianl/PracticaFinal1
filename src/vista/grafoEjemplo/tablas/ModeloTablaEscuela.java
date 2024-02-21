/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.grafoEjemplo.tablas;

import controlador.Exception.EmptyException;
import controlador.TDAListas.DynamicList;
import grafos.modelo.Subestacion;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mrbingus
 */
public class ModeloTablaEscuela extends AbstractTableModel{
    private DynamicList<Subestacion>lista;

   @Override
    public int getRowCount() {
        return lista.getLenght();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Subestacion p = lista.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (p != null) ? p.getNombre() : " ";
                case 1:
                    return (p != null) ? p.getLugar(): "";
                case 2:
                    return (p != null) ? p.getLogo() : "";
                case 3:
                    return (p != null) ? p.getCoordenadas().getLatitud() : "";
                case 4:
                    return (p != null) ? p.getCoordenadas().getLongitud() : "";                    
                default:
                    return null;
            }
        } catch (EmptyException ex) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NOMBRE";
            case 1:
                return "PORTADA";
            case 2:
                return "ESCUDO";
            case 3:
                return "LATITUD";
            case 4:
                return "LONGITUD";                
            default:
                return null;
        }
    }
    
    
    /**
     * @return the lista
     */
    public DynamicList<Subestacion> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DynamicList<Subestacion> lista) {
        this.lista = lista;
    }
    
    
    
}
