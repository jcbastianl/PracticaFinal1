/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDAListas;

/**
 *
 * @author mrbingus
 */
public class Node <E> {
 
     private E info;
        private Node <E> next;

    public Node() {
        next = null;
    }

        
    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }
      public Node(E info){
        this.info = info;
        next= null;
        }

    /**
     * @return the data
     */
    public E getInfo() {
        return info;
    }

    /**
     * @param data the data to set
     */
    public void setInfo(E data) {
        this.info = data;
    }

    /**
     * @return the next
     */
    public Node <E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node <E> next) {
        this.next = next;
    }
        
          
    
}
