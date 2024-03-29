/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author juneau
 */
class NonEmptyBST<D extends Comparable> implements Tree<D> {
    D data;
    Tree<D> left;
    Tree<D> right;
    
    public NonEmptyBST(D elt) {
        data = elt;
        left = new EmptyBST<D>();
        right = new EmptyBST<D>();
    }
    
    public NonEmptyBST(D elt, Tree<D> leftTree, Tree<D> rightTree) {
        data = elt;
        left = leftTree;
        right = rightTree;
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }
    
    public boolean member(D elt) {
        if (data == elt) {
            return true;
        } else {
            if (elt.compareTo(data) < 0) {
                return left.member(elt);
            } else {
                return right.member(elt);
            }
        }
    }
    
    public NonEmptyBST<D> add(D elt) {
        if (data == elt) {
            return this;
        } else {
            if (elt.compareTo(elt) < 0) {
                return new NonEmptyBST<D>(data, left.add(elt), right);
            } else {
                return new NonEmptyBST<D>(data, left, right.add(elt));
            }
        }
    }
}
