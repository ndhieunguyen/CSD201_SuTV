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
public class BuffaloesProblem {
    int noOfBuffaloes;
    int noOfBunches;
    ArrayList<Configuration> solutions;
    boolean solved = false;
    
    // Create a buffaloes problem
    public BuffaloesProblem(int noOfBuffaloes, int noOfBunches) {
        this.noOfBuffaloes = noOfBuffaloes;
        this.noOfBunches = noOfBunches;
        solutions = new ArrayList();
    }
    
    // Check if a suggestion if accepted or not
    private boolean isAccepted(Configuration suggestion){
        int small = suggestion.get(0);
        int big = suggestion.get(1);
        int old = suggestion.get(2);
        if (old%2==1) return false;
        int noBuffaloes = small + big + old;
        int noBunches = small + big*2 + old/2;
        return (noBuffaloes == this.noOfBuffaloes) && (noBunches==this.noOfBunches);
    }
    
    public void solve(){
        solved = false;
        
        // Create backtrack generator
        BackTrackGenerator gen = new BackTrackGenerator();
        gen.addDomain(0, noOfBunches);
        gen.addDomain(0, noOfBunches/2);
        gen.addDomain(0, noOfBunches);
        gen.init();
        Configuration suggestion = gen.getFirstConfig();
        while (suggestion!=null){
            if (isAccepted(suggestion)) solutions.add(suggestion);
            suggestion = gen.nexConfiguration();
        }
        solved = true;
    }
    
    public void printSolutions(){
        if (!solved) System.out.println("Not solved yet");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.println("Solutions:\n[small, big, old]");
            for (Configuration sol: solutions) System.out.println(sol);
            System.out.println(solutions.size() + " solutions");
        }
    }
    
    public static void main(String[] args) {
        int nBuf = Utils.getInt("Enter number of buffaloes: ");
        int nBun = Utils.getInt("Enter number of bunches: ");
        BuffaloesProblem prob = new BuffaloesProblem(nBuf, nBun);
        prob.solve();
        prob.printSolutions();
    }
}
