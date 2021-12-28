
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llpkg;

/**
 *
 * @author LENOVO
 * @param <E>
 */
public interface MyIterator <E>{
    // Checking whether any element is not visited
    public boolean hasNext();
    // Get data of the next element
    public E next();
}
