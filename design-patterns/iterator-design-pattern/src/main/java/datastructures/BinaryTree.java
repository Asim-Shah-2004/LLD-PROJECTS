package datastructures;

import iterators.Iterator;
import iterators.Iterable;
import iterators.BinaryTreeIterator;


public class BinaryTree implements Iterable<Integer> {
    public int val;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int getVal() {
        return val;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    @Override
    public Iterator<Integer> getIterator() {
        return new BinaryTreeIterator(this);
    }
}
