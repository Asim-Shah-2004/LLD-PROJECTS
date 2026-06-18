package datastructures;
import iterators.Iterable;
import iterators.Iterator;
import iterators.LinkedListIterator;

public class LinkedList implements Iterable<Integer> {
    public int val;
    public LinkedList next;
    
    public LinkedList(int val){
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public LinkedList getNext() {
        return next;
    }

    @Override
    public Iterator<Integer> getIterator() {
        return new LinkedListIterator(this);
    }
}