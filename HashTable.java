/**
 * @author:Henry
 * @School:University of Adelaide
 */
package com.henry.java;

public class HashTable {
    //create a inner class Element
    private class Element{
        private int key = 0;
        private int data = 0;
        private int count = 0;
    }
    Element[] ha = new Element[15];
    public HashTable(){
        for(int i = 0;i < ha.length;i++){
            ha[i] = new Element();
        }
    }
    //search the key
    public int searchHashTable(int p,int size,int key){
        int addr = key % p;
        while(ha[addr] != null && ha[addr].key != key){
            addr = (addr + 1) % size;
        }
        if(ha[addr].key == key){
            return ha[addr].data;
        }else{
            return -1;
        }
    }
    //delete one element from the HashTable
    public int deleteHashTable(int p,int size,int key){
        int addr = 0;
        addr = searchHashTable(p,size,key);
        if(addr != -1){
            ha[addr].key = -1;
            return 1;
        }else{
            return -1;
        }
    }
    //insert one element to the HashTable
    public void insertHashTable(int p,int size,int key,int value){
        int addr = key % p;
        int i = 1;
        if(ha[addr].key == 0 || ha[addr].key == -1){
            ha[addr].key = key;
            ha[addr].count = 1;
            ha[addr].data = value;
        }else{
            do{
                addr = (addr + 1) % size;
                i++;
            }while(ha[addr].key != 0 && ha[addr].key != -1 );

            ha[addr].key = key;
            ha[addr].data = value;
            ha[addr].count = i;
        }
    }
    public static void main(String[] args){
        HashTable ht = new HashTable();
        ht.insertHashTable(8,13,5,12);
        System.out.println(ht.searchHashTable(8,13,5));
    }
}
