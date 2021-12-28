/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llpkg;

/**
 *
 * @author LENOVO
 */
public class MySortedLL {
    LL_Element head;
    LL_Element tail;
    
    public MySortedLL() {
        head=tail=null;
    }
    
    public LL_Element ceiling(Comparable x){
        LL_Element t = head;
        while (t!=null && t.data.compareTo(x)<0)
            t=t.next;
        return t;
    }
    
    public LL_Element search(Comparable x){
        LL_Element result = ceiling(x);
        if (result==null) return null;
        return (result.data.compareTo(x)==0) ? result : null;
    }
    
    public LL_Element add(Comparable x){
        LL_Element newEle = new LL_Element(x);
        LL_Element after = ceiling(x);
        // Case of the list is empty
        if (head==null) head=tail=newEle;
        // Case of the list is not empty
        else if (after==null){ // There is no ceiling, add x to the end
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail=newEle;
        }
        else if (after==head){ // add x to the begining
            newEle.next = head;
            newEle.previous = null;
            head.previous = newEle;
            head = newEle;
        }
        else{ // Order: before <-> newEle <-> after
            LL_Element before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            after.previous = newEle;
            before.next = newEle;
        }
        return newEle;
    }
    
    public void add(Comparable... group){
            for (Comparable data:group) add(data);
    }
    
    private LL_Element remove(LL_Element remRef){
        // if the list has only one element and it will be removed
        if (remRef==head && head==tail){
            head=tail=null;
            return remRef;
        }
        LL_Element before = remRef.previous;
        LL_Element after = remRef.next;
        // the list has more than one element
        if (remRef==head) { // remove first element
            after.previous = null;
            head = after;
        }
        else if (remRef==tail){ // remove last element
            before.next = null;
            tail = before;
        }
        else{ // order: before <-> remRef <-> after
            before.next = after;
            after.previous = before;
        }
        return remRef;
    }
    
    public LL_Element remove(Comparable x){
        LL_Element remRef = search(x);
        if (remRef!=null) remove(remRef);
        return remRef;
    }
    
    // inner class as a tool for traversing all data in the list
    private class Traverser implements MyIterator<Comparable>{
        // Data structure of Traverser: curRef -> head -> ... -> tail
        LL_Element curRef;
        public Traverser() {
            curRef = new LL_Element(null);
            curRef.next=head;
        }
        
        @Override
        public boolean hasNext() {
            return (curRef.next!=null);
        }
        @Override
        public Comparable next() {
            curRef = curRef.next;
            return curRef.data;
        }
    }
    
    public MyIterator iterator(){
        if (head==null) return null;
        return new Traverser();
    }
} // End of the MySortedLL class