package byo.util.container;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
public class ArrayList<E> implements Collection{
    private static final int DEFAULT_CAPACITY = 8;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    Object[] buffer;
    int size;

    public ArrayList(int capacity){
        buffer = new Object[capacity];
        size = 0;
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
        ensureCapacity(size+1);
        buffer[size++]=o;
        return true;
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

    private void ensureCapacity(int capacity){
        if (capacity>buffer.length){
            grow(capacity);
        }
    }
    private void grow(int capacity){
        int oldCapacity = buffer.length;
        //增长一半
        int newCapacity = oldCapacity + (oldCapacity>>1);
        if (newCapacity < capacity){
            newCapacity = capacity;
        }
        if(newCapacity> MAX_ARRAY_SIZE){
            if(capacity<MAX_ARRAY_SIZE){
                newCapacity = MAX_ARRAY_SIZE;
            }else{
                throw new OutOfMemoryError();
            }
        }
        log.debug("grow size={},oldCapacity={},newCapacity={}",capacity,oldCapacity,newCapacity);
        Object[] temp = Arrays.copyOf(buffer,newCapacity);
        buffer = temp;
    }
}
