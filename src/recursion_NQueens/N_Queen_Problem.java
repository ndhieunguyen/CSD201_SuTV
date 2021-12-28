/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion_NQueens;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class N_Queen_Problem {
    int size, nQueens; // size of chessboard, number of queens
    ArrayList<QueenPosition> position = null; // Chessboard
    ArrayList<QueenPosition> solution;
    public boolean solved = false; 
    public boolean succeeded = false;

    public N_Queen_Problem(int size, int nQueens) {
        this.size = size;
        this.nQueens = nQueens;
        
        // Set up chessboard
        position = new ArrayList();
        int i, j;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                position.add(new QueenPosition(i, j));
            }
        }
    }
    
    public boolean reverseValid(QueenPosition pos, int index) {
        if (index==0) return true;
        for (int i = index-1; i >= 0; i--) {
            QueenPosition p = solution.get(i);
            if (!pos.valid(p)) return false;
        }
        return true;
    }
    
    private void recursiveSolve (int index){
        if (solved) return;
        int i, j;
        
        // Choose a position for the index queen
        for (i = 0; i < position.size() && !solved; i++) {
            // Remove positions from the index 
            j = solution.size()-1;
            while (j>=index) solution.remove(j--);
            QueenPosition pos = position.get(i);
            if (reverseValid(pos, index)){
                solution.add(pos);
                for (int k = 0; k < solution.size(); k++) {
                    System.out.print(solution.get(k).toString() + " ");
                }
                System.out.println("");
                if (index==nQueens-1){
                    solved = succeeded = true;
                }
                else recursiveSolve(index+1);
            }
        }
    }
    
    private void recursiveSolve(){
        solved = succeeded = false;
        if (this.size < this.nQueens) solved = true;
        else{
            solution = new ArrayList();
            recursiveSolve(0);
        }
    }
    
    public static void main(String[] args) {
        int size=8;
        int nQueens=8;
        N_Queen_Problem problem = new N_Queen_Problem(size, nQueens);
        
        // Using recursive approach to solve the problem for only ONE solution
        problem.recursiveSolve();
        if (problem.solved){
            if (problem.succeeded){
                System.out.println("A solution: ");
                System.out.println(problem.solution);
            }
            else System.out.println("No solution !");
        }
        else System.out.println("The problem is not solved yet");
    }
}
