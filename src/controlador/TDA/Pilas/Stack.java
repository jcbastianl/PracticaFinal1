/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.Pilas;

import controlador.Exception.EmptyException;
import controlador.TDAListas.DynamicList;

/**
 *
 * @author mrbingus
 */
class Stack<E> extends DynamicList<E>{
    private Integer tope;

    public Stack(Integer tope) {
        this.tope = tope;
    }

    public Boolean isFull(){
        return getLenght().intValue() >= tope.intValue();
    }
    
    public void push(E info) throws EmptyException, FullStackException{ 
        if (isFull()) {
           throw new FullStackException("STACK FULL");
        }else{
             add(info, 0);
 
        }
    
    }
    
    public E pop() throws EmptyException{
    
        E info = extractFirs();
        return info;
    
    
    }
            
            
            
    
}
