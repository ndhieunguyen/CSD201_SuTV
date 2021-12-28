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

/**
 *
 * @author LENOVO
 */
public class DogsAndChickens {
    int nLegs=0;
    ArrayList<Configuration> solutions;
    boolean solved=false;
    
    // Create a buffaloes problem
    public DogsAndChickens (int nLegs) {
        if (nLegs>0) this.nLegs = nLegs;
        solutions = new ArrayList();
    }
    
    // Check if a suggestion is accepted of not 
    private boolean isAccepted (Configuration suggestion) {
        int dogs = suggestion.get(0);
        int chickens = suggestion.get(1);
        return (4*dogs + 2*chickens) == nLegs;
    }
    
    public void solve() {
        solved = false;
        
        // Create backtrack generator 
        BackTrackGenerator gen = new BackTrackGenerator();
        
        // Set up domains for dogs and chickens
        gen.addDomain(1, (nLegs-2)/4); // Dog domain
        gen.addDomain(1, (nLegs-4)/2); // Chicken domain
        gen.init();
        Configuration suggestion = gen.getFirstConfig();
        while (suggestion!=null) {
            if (isAccepted(suggestion)) solutions.add(suggestion);
            suggestion = gen.nexConfiguration();
        }
        solved = true;
    }
    
    // print solutions
    public void printSolutions(){
        if (!solved) System.out.println("Not solved yet");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.println("Solutions: \n [dogs, chickens]");
            for (Configuration sol: solutions) System.out.println(sol);
            System.out.println(solutions.size() + " solution(s)");
        }
    }
    
    public static void main(String[] args) {
        int nLegs = Utils.getInt("Enter number of legs: ");
        DogsAndChickens prob = new DogsAndChickens(nLegs);
        prob.solve();
        prob.printSolutions();
    }
}
