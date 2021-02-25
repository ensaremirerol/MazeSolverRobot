/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensar.mazesolverrobot;

/**
 *
 * @author ensar
 */
public class HashMap {
    class Node{
        public int hash;
        public Hashable data;
        public Node next;

        public Node(int hash, Hashable data) {
            this.hash = hash;
            this.data = data;
        }
    }
    
    Node root;
    Node curr;
    Node temp;

    public HashMap() {
    }
    
    public boolean add(Hashable data){
        int hash = data.hash();
        if(serach(data) != null){
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
        
        return true;
    }
    
    public Hashable serach(Hashable data){
        int hash = data.hash();
        temp = root;
        while(temp != null){
            if(temp.hash == hash) return temp.data;
        }
        return null;
    }
    
    public Hashable getCachedData(){
        return temp.data;
    }
}
