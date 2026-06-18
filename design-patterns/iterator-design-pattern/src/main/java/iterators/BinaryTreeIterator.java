package iterators;

import datastructures.BinaryTree;

public class BinaryTreeIterator implements Iterator<Integer> {
    
    private BinaryTree binaryTree;
    
    public BinaryTreeIterator(BinaryTree binaryTree){
        this.binaryTree = binaryTree;
    }

    @Override
    public boolean hasNext() {
        return this.binaryTree != null;
    }
    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        int val = this.binaryTree.getVal();
        this.binaryTree = this.binaryTree.getLeft();
        return val;
    }
}
