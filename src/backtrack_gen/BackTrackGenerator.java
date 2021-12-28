/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtrack_gen;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author LENOVO
 */
public class BackTrackGenerator {
    protected int noOfSet=0;
    ArrayList<IntMinMaxSet> iDomains = new ArrayList();
    Configuration curConfig = new Configuration();
    boolean initiated = false; // whether the generator is initiated or not
    
    // Add a domain specified by min and max values
    public void addDomain(int min, int max){
        IntMinMaxSet aSet = new IntMinMaxSet(min, max);
        iDomains.add(aSet);
        noOfSet+=1;
    }
    
    // Add a domain specified by a list of real objects
    public void addDomain(Collection list){
        IntMinMaxSet aSet = new IntMinMaxSet(list);
        iDomains.add(aSet);
        noOfSet+=1;
    }
    
    // Initiate the generator
    public void init(){
        // Set up the initial configuration
        curConfig.clear();
        for (int i = 0; i < noOfSet; i++) {
            IntMinMaxSet set = iDomains.get(i);
            set.reset();
            curConfig.add(set.nextValue());
        }
        initiated = true;
    }
    
    // Reset the generator 
    public void reset(){
        initiated = false;
    }
    
    // Check whether the generator is in the last configuration
    private boolean isLastConfiguration() {
        for (int i = 0; i < noOfSet; i++) {
            if (!iDomains.get(i).isLastValue()) return false;
        }
        return true;
    }
    
    // Get a copy of the current configuration
    // The curConfiguration of the generator must be reserved
    private Configuration copyConfiguration() {
        Configuration result = new Configuration(curConfig.size());
        for (int i = 0; i < curConfig.size(); i++) {
            result.add(curConfig.get(i).intValue());
        }
        return result;
    }

    public Configuration getFirstConfig(){
        init();
        return copyConfiguration();
    }
    
    public Configuration nexConfiguration() {
        if (!initiated || isLastConfiguration()) return null;
        int lastIndex = noOfSet-1;
        
        // Get the last set which is not in the end position
        // 0123[4]99999, 9: the last value --> lastIndex=4
        while (lastIndex>=0 && iDomains.get(lastIndex).isLastValue())
            lastIndex-=1;
        // Set up next configuration (0123[5]99999) 
        int nextValue = iDomains.get(lastIndex).nextValue(); // 5
        curConfig.update(lastIndex, nextValue);
        
        // Because the last 5 digit has reached max 
        // -> 4 will be raised
        // -> index of 4 >=0 -> index after 4 has reached max
        // -> reset after index 4
        if (lastIndex>=0) // 01235[99999]
            // Reset all set after the position lastIndex
            for (int i = lastIndex+1; i < noOfSet; i++) {
                // 01235[99999] -> 0123500000
                IntMinMaxSet aSet = iDomains.get(i);
                aSet.reset(); // curValue in this set: -1
                // use aSet.nextValue() to turn -1 into 0
                curConfig.update(i, aSet.nextValue()); // 9 -> 0
            }
        return copyConfiguration();
    }
    
    
}
