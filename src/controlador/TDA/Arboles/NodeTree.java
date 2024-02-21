/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.Arboles;

/**
 *
 * @author mrbingus
 */
public class NodeTree <E>{
    private E data;
    private NodeTree<E> father;
    private NodeTree<E> left;
    private NodeTree<E> rigth;

    public NodeTree(E data) {
        this.data = data;
        father = null;
        left = null;
        rigth = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeTree<E> getFather() {
        return father;
    }

    public void setFather(NodeTree<E> father) {
        this.father = father;
    }

    public NodeTree<E> getLeft() {
        return left;
    }

    public void setLeft(NodeTree<E> left) {
        this.left = left;
    }

    public NodeTree<E> getRigth() {
        return rigth;
    }

    public void setRigth(NodeTree<E> rigth) {
        this.rigth = rigth;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
    
    
    
    
    
}
