/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author LENOVO
 */
public class DSWIntBstTreeDemo {
    public static void main(String[] args) {
        DSWIntBstTree tree = new DSWIntBstTree();
        for (int i=1; i<31 ; i++)
            tree.add(i);
//        tree.add(9, 8, 4, 3, 2, 1);
        System.out.println("\nInitital tree:\n");
        tree.printAlign();
        tree.DSW_Balance();
        System.out.println("\nBalanced tree:\n");
        tree.printAlign();
    }
}
