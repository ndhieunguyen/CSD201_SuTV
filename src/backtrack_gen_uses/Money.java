/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_uses;

import Utils.Utils;
import backtrack_gen.BackTrackGenerator;
import backtrack_gen.Configuration;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author LENOVO
 */
public class Money {
    int amount;
    ArrayList<Integer> denominations;
    ArrayList<Configuration> solutions;
    boolean solved = false;

    public Money(int amount, ArrayList<Integer> denominations) {
        this.amount = amount;
        Collections.sort(denominations);
        this.denominations = denominations;
        solutions = new ArrayList();
    }

    public boolean isAccepted(Configuration solution){
        int sum=0;
        for (int i = 0; i < denominations.size(); i++) {
            sum += solution.get(i) * denominations.get(i);
        }
        return sum==amount;
    }
    
    public void solve() {
        solved = false;
        
        // Create backtrack generator 
        BackTrackGenerator gen = new BackTrackGenerator();
        
        // Set up domains for denominations
        for (int i = 0; i < denominations.size() ; i++) {
            gen.addDomain(0, amount/denominations.get(i));
        }
        gen.init();
        Configuration suggestion = gen.getFirstConfig();
        while (suggestion!=null) {
            if (isAccepted(suggestion)) solutions.add(suggestion);
            suggestion = gen.nexConfiguration();
        }
        solved = true;
    }
    
    public void printSolutions(){
        if (!solved) System.out.println("Not solved yet");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.print("Solutions:\n[");
            for (int i = 0; i < denominations.size(); i++) {
                System.out.print(denominations.get(i) + ", ");
            }
            System.out.println("]");
            for (Configuration sol: solutions) System.out.println(sol);
            System.out.println(solutions.size() + " solution(s)");
        }
    }
    
    public static void main(String[] args) {
        int amount = Utils.getInt("Enter amount of money: ");
        int noOfDenominations = Utils.getInt("Enter number of denominations: ");
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < noOfDenominations; i++) {
            list.add(Utils.getInt("Enter denomination " + (i+1) + ": "));
        }
        Money prob = new Money(amount, list);
        prob.solve();
        prob.printSolutions();
    }
}
