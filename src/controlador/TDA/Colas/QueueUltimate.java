/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.Colas;

import controlador.TDA.Pilas.*;
import controlador.Exception.EmptyException;

/**
 *
 * @author mrbingus
 */
public class QueueUltimate<E>  {
    private Queue<E> tail;

    public QueueUltimate(Integer length) {
        this.tail = new Queue<>(length);
    }
    
    public void queue(E info) throws EmptyException, FullStackException{
        tail.queue(info);
    }
    
    public E dequeue() throws EmptyException{
        return tail.dequeue();

    }
    
    public Integer lenght(){
        return tail.getLenght();
    }
    
    public Boolean isFull(){
        return tail.isFull();
    }
    
    public void print(){
        System.out.println("STACK");
        System.out.println(tail.toString()+"\n");
    
    }    
    
}
