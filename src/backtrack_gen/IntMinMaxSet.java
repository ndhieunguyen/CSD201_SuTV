/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;

import java.util.Collection;

/**
 *
 * @author LENOVO
 */
public class IntMinMaxSet {
    private int minVal = 0;
    private int maxVal = 0;
    int curVal = minVal-1;
    
    // Create a set using min and max value
    public IntMinMaxSet (int min, int max){
        if (min>max){
            min+=max;
            max=min-max;
            min=min-max;
        }
        this.minVal = min;
        this.maxVal = max;
        this.curVal = minVal-1;
    }

    // Create a set from a collection
    public IntMinMaxSet(Collection collection) {
        this.minVal = 0;
        this.maxVal = collection.size()-1;
        curVal = minVal-1;
    }
    
    // Check if the set still has a next value
    public boolean hasNext(){
        return curVal+1 < maxVal;
    }
    
    // Check if the curVal is the last value or not
    public boolean isLastValue(){
        return curVal==maxVal;
    }
    
    // Get the next value in the set
    public int nextValue(){
        if (this==null) throw new RuntimeException("The set is empty !");
        if (this.isLastValue()) throw new RuntimeException("End of the set !");
        return ++curVal;
    }
    
    // Reset the set to the original state
    public void reset() {
        curVal = minVal-1;
    }
}
