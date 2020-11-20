package byo.util.container;

import java.util.Iterator;

public class ArrayList<E> implements Collection{
    private static final int DEFAULT_CAPACITY = 8;
    Object[] buffer;
    int size;

    public ArrayList(int capacity){
        buffer = new Object[capacity];
        size = capacity;
    }
    public ArrayList(){
        this(ArrayList.DEFAULT_CAPACITY);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public int indexOf(Object o){
        if(o==null){
            for(int i=0;i<size;i++){
                if(buffer[i]==null){
                    return i;
                }
            }
        }
        for(int i=0;i<size;i++){
            if(o.equals(buffer[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
