/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import com.thoughtworks.xstream.XStream;
import controlador.TDAListas.DynamicList;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author mrbingus
 */
public class DaoImplement <T> implements DaoInterface <T>{ 

    private Class<T>  clazz;
    private XStream conection;
    private String  URL;

    public DaoImplement(Class<T> clazz) {
        this.clazz = clazz;
        conection = Bridge.getConection();
        URL = Bridge.URL+clazz.getSimpleName()+ ".json";
    }

    
    @Override
    public Boolean persist(T data) {
        DynamicList<T>  ld = all();
        ld.add(data);
        try{
            getConection().toXML(ld, new FileWriter(URL));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    

    @Override
    public Boolean merge(T data, Integer index) {
        try {
            DynamicList<T> list = all();
            list.merge(data, index);
            getConection().toXML(list, new FileWriter(URL));
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    
    public DynamicList<T> all(){
        DynamicList<T> dl = new DynamicList<>();
        try{
            dl = (DynamicList<T>) getConection().fromXML(new FileReader(URL));
        }catch (Exception e){
            
        }
        return dl;
    }

 
    /**
     * @return the conection
     */
    public XStream getConection() {
        return conection;
    }

    
    
    
}
