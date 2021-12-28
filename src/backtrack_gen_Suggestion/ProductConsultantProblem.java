/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen_Suggestion;

import backtrack_gen.BackTrackGenerator;
import backtrack_gen.Configuration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 *
 * @author LENOVO
 */
public class ProductConsultantProblem {
    double maxBudget;
    int noProduct;
    ArrayList<ArrayList<Product>> domains;
    boolean solved = false;
    ArrayList<Suggestion> solutions;
    
    // Set up the problem
    public ProductConsultantProblem(double maxBudget) {
        this.maxBudget = maxBudget;
        noProduct=0;
        domains = new ArrayList();
        solutions = new ArrayList();
    }
    
    // Add a product type (domain) which is required to buy
    public void addRequest(ArrayList<Product> domain){
        noProduct+=1;
        domains.add(domain);
    }
    
    // get a real solution from a configuration
    public Suggestion getSuggestion(Configuration conf){
        Suggestion suggestion = new Suggestion();
        double sumCost=0;
        for (int i = 0; i < domains.size(); i++) {
            ArrayList<Product> domain = domains.get(i);
            int productIndex = conf.get(i);
            Product p = domain.get(productIndex);
            suggestion.add(p);
            sumCost += domain.get(productIndex).price;
        }
        suggestion.setCost(sumCost);
        return suggestion;
    }
    
    public boolean isAccepted(Suggestion suggestion){
        return suggestion.getCost()<=this.maxBudget;
    }
    
    public void solve(){
        solved = false;
        // Create backtrack generator
        BackTrackGenerator gen = new BackTrackGenerator();
        // Set up all domains
        for (int i = 0; i < noProduct; i++) {
            gen.addDomain(domains.get(i));
        }
        gen.init();
        Configuration config = gen.getFirstConfig();
        while (config!=null) {
            Suggestion suggestion = this.getSuggestion(config);
            if (isAccepted(suggestion)) solutions.add(suggestion);
            config=gen.nexConfiguration();
        }
        solved = true;
    }
    
    public void printSolutions(){
        if (!solved) System.out.println("Not solved yet");
        else if (solutions.isEmpty()) System.out.println("No solution !");
        else {
            System.out.format("Maximum budget: %.0f\n", maxBudget);
            Collections.sort(solutions);
            for (int i = 0; i < solutions.size(); i++) {
                Suggestion sol = solutions.get(i);
                System.out.format("Solution %d: %.0f\n", (i+1), sol.getCost());
                System.out.println(sol);
            }
            System.out.println(solutions.size() + " solution(s)");
        }
    }
}