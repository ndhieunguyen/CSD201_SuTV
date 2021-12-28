/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion_NQueens;

/**
 *
 * @author LENOVO
 */
public class QueenPosition {
    int x, y;

    public QueenPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Checking whether 2 queen's position are valid or not
    public boolean valid(QueenPosition p){
        int dx = Math.abs(this.x - p.x);
        int dy = Math.abs(this.y - p.y);
        return ((dx != 0) && (dy != 0) && (dy != dx));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }   
}
