/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.TDA.Arboles;

import controlador.TDAListas.DynamicList;

/**
 *
 * @author mrbingus
 */
public class TreeInteger {

    private NodeTree<Integer> root;
    private Integer height;
    private DynamicList<DynamicList<NodeTree>> levels;
    private DynamicList<NodeTree> orders;
    private Integer nro_nodes;

    public TreeInteger() {
        root = null;
        height = 0;
        nro_nodes = 0;
        levels = new DynamicList<>();
        orders = new DynamicList<>();
    }

    public NodeTree<Integer> getRoot() {
        return root;
    }

    public void setRoot(NodeTree<Integer> root) {
        this.root = root;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public DynamicList<DynamicList<NodeTree>> getLevels() {
        return levels;
    }

    public void setLevels(DynamicList<DynamicList<NodeTree>> levels) {
        this.levels = levels;
    }

    public DynamicList<NodeTree> getOrders() {
        return orders;
    }

    public void setOrders(DynamicList<NodeTree> orders) {
        this.orders = orders;
    }

    public Integer getNro_nodes() {
        return nro_nodes;
    }

    public void setNro_nodes(Integer nro_nodes) {
        this.nro_nodes = nro_nodes;
    }

    private Integer calcHeigth(NodeTree tree) {
        if (tree == null) {
            return 0;
        } else {
            Integer left = calcHeigth(tree.getLeft());
            Integer right = calcHeigth(tree.getRigth());
            if (left.intValue() > right.intValue()) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }

    private void calcLevels(NodeTree tree, Integer level) throws Exception {
        if (tree != null) {
            levels.getInfo(level).add(tree);
            level++;
            calcLevels(tree.getLeft(), level);
            calcLevels(tree.getRigth(), level);
        } else if (level.intValue() != getHeight().intValue()) {
            levels.getInfo(level).add(null);
            level++;
            calcLevels(null, level);
            calcLevels(null, level);
        }
    }

    private void levels() throws Exception {
        levels = new DynamicList<>();
        this.height = calcHeigth(root);
        for (int i = 0; i <= this.height; i++) {
            levels.add(new DynamicList<>());
        }
        calcLevels(root, 0);
        levels.extract(levels.getLenght() - 1);
    }

    public Boolean insert(Integer data) throws Exception {
        if (root == null) {
            root = new NodeTree<>(data);
            nro_nodes++;
            levels();
            return true;
        } else {
            NodeTree<Integer> nuevo = new NodeTree<>(data);
            NodeTree<Integer> recent = root;
            NodeTree<Integer> father;
            while (true) {
                father = recent;
                if (data.intValue() == recent.getData().intValue()) {
                    return false;
                } else if (data.intValue() < recent.getData().intValue()) {
                    recent = recent.getLeft();
                    if (recent == null) {
                        nuevo.setFather(father);
                        father.setLeft(nuevo);
                        nro_nodes++;
                        levels();
                        return true;
                    }
                } else {
                    recent = recent.getRigth();
                    if (recent == null) {
                        nuevo.setFather(father);
                        father.setRigth(nuevo);
                        nro_nodes++;
                        levels();
                        return true;
                    }
                }
            }
        }
    }

    private void pre_order(NodeTree<Integer> tree) {
        if (tree != null) {
            orders.add(tree);
            pre_order(tree.getLeft());
            pre_order(tree.getRigth());

        }

    }

    private void pre_order() {
        orders = new DynamicList<>();
        pre_order(root);

    }

    private void post_order(NodeTree<Integer> tree) {
        if (tree != null) {
            orders.add(tree);
            post_order(tree.getRigth());
            post_order(tree.getLeft());
        }

    }

    private void post_order() {
        orders = new DynamicList<>();
        post_order(root);

    }

    private void in_order(NodeTree<Integer> tree) {
        if (tree != null) {

            in_order(tree.getLeft());
            orders.add(tree);
            in_order(tree.getRigth());
        }

    }

    private void in_order() {
        orders = new DynamicList<>();
        in_order(root);

    }

    public static void main(String[] args) {
        try {
            /* int n = 15;
                        int x = 0;
                        int aux[] = IntStream.rangeClosed(1, 15).toArray();
                        for (int i = 0; i < aux.length; i++) {
                                aux[i] = aux[i]* ((int) (Math.random()*1000));
                                //System.out.println(aux[i]);
                        }
                        Arrays.sort(aux);
                        int medio = aux.length/2;
                        int sal = aux[0];
                        aux[0] = aux[medio];
                        aux[medio] = sal;
                        System.out.println(medio + " medio: " + aux[medio] + " aux 0 ");
                        TreeInteger arbol = new TreeInteger();
                        arbol.Insert(aux[0]);
                        for (int i = 0; i < aux.length; i++) {
                                //System.out.println(aux[i]);
                                arbol.Insert(aux[i]);
                        }
                        System.out.println("Altura del arbol: " + arbol.getHeight());
                        System.out.println("Niveles del arbol: " + arbol.getLevels().getLength());*/
            TreeInteger arbol = new TreeInteger();
            arbol.insert(100);
            arbol.insert(70);
            arbol.insert(130);
            arbol.insert(50);
            arbol.insert(80);
            arbol.insert(110);
            arbol.insert(150);
            System.out.println("Altura del arbol: " + arbol.getHeight());
            System.out.println("Niveles del arbol: " + arbol.getLevels().getLenght());

            System.out.println("preor");
            arbol.pre_order();
            System.out.println(arbol.getOrders().toString());
            
            System.out.println("postor");
            arbol.post_order();
            System.out.println(arbol.getOrders().toString());            
            
             System.out.println("inor");
            arbol.in_order();
            System.out.println(arbol.getOrders().toString());
            
            System.out.println("\t\t" + arbol.getRoot() + "\n");
            System.out.println("    " + arbol.getRoot().getLeft() + "\t\t  \t" + arbol.getRoot().getRigth() + "\n");
            System.out.println(arbol.getRoot().getLeft().getLeft() + "  \t" + arbol.getRoot().getLeft().getRigth() + "\t  " + arbol.getRoot().getRigth().getLeft() + "\t\t" + arbol.getRoot().getRigth().getRigth());

        } catch (Exception e) {
        }
    }

}
