/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_uses;

import Utils.*;
import backtrack_gen.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class BitStringProblem {
    int nBit;
    ArrayList<Configuration> solutions;
    boolean solved = false;
    
    // Construct the problem with nBit
    public BitStringProblem(int nBit){
        this.nBit = nBit;
        solutions = new ArrayList();
    }
    
    // Check if a suggestion is accepted or not
    private boolean isAccepted(Configuration conf){
        // return true because in this project,
        // we create all list of bit string with len=nBit
        // -> all bit string with len=nBit will be accepted
        return true;
    }
    
    public void solve(){
        solved=false; // Not solved yet
        
        // Create backtrack generator
        BackTrackGenerator gen = new BackTrackGenerator();
        
        // Set up all domains are boolean set
        for (int i = 0; i < nBit; i++) gen.addDomain(0,1);
        gen.init();
        Configuration suggestion = gen.getFirstConfig();
        while (suggestion!=null) {
            if (isAccepted(suggestion)) solutions.add(suggestion);
            suggestion = gen.nexConfiguration();
        }
        solved=true;
    }
        // Print solutions
    public void printSolutions(){
        if (!solved) System.out.println("Not solved yet !");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.println("Solutions: " + this.nBit + " bit strings");
            for (Configuration sol: solutions) System.out.println(sol);
            System.out.println(solutions.size() + " solution(s).");
        }
    }
    
    public String concatArray(Configuration con){
        String tmp = "";
        for (int i = 0; i < con.size(); i++) {
            tmp+=con.get(i).toString();
        }
        return tmp;
    }
    
    public void printSolutions2(){
        if (!solved) System.out.println("Not solved yet !");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.println("Solutions: " + this.nBit + " bit strings");
            for (Configuration sol: solutions) System.out.println(concatArray(sol));
            System.out.println(solutions.size() + " solution(s).");
        }
    }
    
    public static void main(String[] args) {
        int nBit = Utils.getInt("Enter lenght of bit string: ");
        BitStringProblem prob = new BitStringProblem(nBit);
        prob.solve();
        prob.printSolutions2();
    }
}
