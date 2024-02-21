/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.Colas;

import controlador.TDA.Pilas.*;
import controlador.Exception.EmptyException;
import controlador.TDAListas.DynamicList;

/**
 *
 * @author mrbingus
 */
class Queue<E> extends DynamicList<E>{
    private Integer cima;

    public Queue(Integer tope) {
        this.cima = tope;
    }

    public Boolean isFull(){
        return getLenght().intValue() >= cima.intValue();
    }
    
    public void queue(E info) throws EmptyException, FullStackException{ 
        if (isFull()) {
           throw new FullStackException("QUEUE FULL");
        }else{
             add(info);
        }
    }
    
    public E dequeue() throws EmptyException{
    
        E info = extractFirs();
        return info;
    
    
    }
            
            
            
    
}
