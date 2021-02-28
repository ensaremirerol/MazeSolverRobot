/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensar.mazesolverrobot;

import java.util.Iterator;

/**
 *
 * @author ensar
 */

class Node{
    public int hash;
    public Hashable data;
    public Node next;

    public Node(int hash, Hashable data) {
        this.hash = hash;
        this.data = data;
    }
}

public class HashTable implements Iterable<Hashable>{
    @Override
    public Iterator<Hashable> iterator() {
        return new HashMapIterator(root);
    }
    
    private Node root;
    private Node curr;
    private Node temp;
    private int size;

    public HashTable() {
        size = 0;
    }
    
    public boolean add(Hashable data){
        int hash = data.hash();
        if(search(data) != null){
            return false;
        }
        if(root == null){
            root = new Node(hash, data);
            curr = root;
        }
        else{
            curr.next = new Node(hash, data);
            curr = curr.next;
        }
        size++;
        return true;
    }
    
    public Hashable search (Hashable data){
        int hash = data.hash();
        temp = root;
        while(temp != null){
            if(temp.hash == hash) return temp.data;
            temp = temp.next;
        }
        return null;
    }
    
    public Hashable getCachedData(){
        return temp.data;
    }

    public int getSize() {
        return size;
    }
}

class HashMapIterator implements Iterator<Hashable>{
    Node root;

    public HashMapIterator(Node root){
        this.root = root;
    }
    @Override
    public boolean hasNext() {
        return root != null;
    }

    @Override
    public Hashable next() {
        Hashable retVal = root.data;
        root = root.next;
        return retVal;
    }
}
