/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import Utils.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class IntBstDemo {

    public static void main(String[] args) {
        Menu m = new Menu();
        m.add("Add new key");
        m.add("Maximum value");
        m.add("Minimum value");
        m.add("Average value");
        m.add("Tree's height");
        m.add("Breadth-first output");
        m.add("Align output");
        m.add("Pre-order output");
        m.add("In-order output (LNR)");
        m.add("In-order output (RNL)");
        m.add("Post-order output");
        m.add("Searching a key");
        m.add("Removing a key by merging");
        m.add("Removing a key by copying");

        IntBstTree tree = new IntBstTree();
        tree.add(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29);
//        tree.add(1, 5, 15, 17, 34, 37, 45, 85, 3);
        int choice;
        int x;
        do {
            choice = m.getUserChoice();
            switch (choice) {
                case 1: {
                    x = Utils.getInt("Enter a key: ");
                    if (tree.add(x)) {
                        System.out.println("Adding " + x + " successfully");
                    } else {
                        System.out.println("Adding failed");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Max value: " + tree.getMax());
                    break;
                }
                case 3: {
                    System.out.println("Min value: " + tree.getMin());
                    break;
                }
                case 4: {
                    System.out.println("Average value: " + tree.getAverage());
                    break;
                }
                case 5: {
                    System.out.println("Tree's height: " + tree.getHeight());
                    break;
                }
                case 6: {
                    System.out.println("Breadth-first / level-based:\n");
                    tree.printLevelBased();
                    break;
                }
                case 7: {
                    System.out.println("Tree in aligned format:\n");
                    tree.printAlign();
                    break;
                }
                case 8: {
                    System.out.println("Tree in pre-order list:\n");
                    tree.printNLR();
                    break;
                }
                case 9: {
                    System.out.println("Tree in in-order list (LNR):\n");
                    tree.printLNR();
                    break;
                }
                case 10: {
                    System.out.println("Tree in in-order list (RNL):\n");
                    tree.printRNL();
                    break;
                }
                case 11: {
                    System.out.println("Tree in post-order list:\n");
                    tree.printLRN();
                    break;
                }
                case 12: {
                    x = Utils.getInt("Searching for value: ");
                    IntBstNode node = tree.search(x);
                    if (node == null) {
                        System.out.println("Not found !!!");
                    } else {
                        System.out.println("Found: " + node.key);
                    }
                    break;
                }
                case 13: {
                    x = Utils.getInt("Delete value: ");
                    if (tree.deleteByMerging(x)) {
                        System.out.println("Delete successfully !!!");
                    } else {
                        System.out.println("Delete failed !!!");
                    }
                    break;
                }
                case 14: {
                    x = Utils.getInt("Delete value: ");
                    if (tree.deleteByCopying(x)) {
                        System.out.println("Delete successfully !!!");
                    } else {
                        System.out.println("Delete failed !!!");
                    }
                    break;
                }
            }
        } while (choice > 0 && choice <= m.size());
    }
}
