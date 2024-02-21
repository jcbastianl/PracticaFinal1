/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO;

import controlador.TDAListas.DynamicList;

/**
 *
 * @author mrbingus
 */
public interface DaoInterface <T>{
    
    public Boolean persist(T data);
    public Boolean merge (T data, Integer index);
    public DynamicList<T> all();
        
    
}
