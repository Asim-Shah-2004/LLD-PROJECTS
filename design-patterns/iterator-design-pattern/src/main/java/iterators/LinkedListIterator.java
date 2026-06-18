package iterators;

import datastructures.LinkedList;

public class LinkedListIterator implements Iterator<Integer> {
    
    private LinkedList linkedList;
    
    public LinkedListIterator(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    @Override
    public boolean hasNext() {
        return this.linkedList != null;
    }
    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        int val = this.linkedList.getVal();
        this.linkedList = this.linkedList.getNext();
        return val;
    }
}
