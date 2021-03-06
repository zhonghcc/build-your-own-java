package byo.util.container;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
public class ArrayList<E> implements Collection<E>{
    private static final int DEFAULT_CAPACITY = 8;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] buffer;
    private int size;

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
    public boolean contains(E o) {
        return indexOf(o)>=0;
    }

    @Override
    public boolean add(E o) {
        ensureCapacity(size+1);
        buffer[size++]=o;
        return true;
    }

    @Override
    public boolean remove(E o) {
        int index = indexOf(o);
        return remove(index);
    }
    public boolean remove(int index){
        if(index<0){
            return false;
        }
        System.arraycopy(buffer,index+1,buffer,index,size-index);
        buffer[size--]=null;//Let GC
        return true;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            buffer[i]=null;//Let GC
        }
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    public E get(int index){
        if(index>=size||index<0){
            return null;
        }
        return (E)buffer[index];
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

    private class ArrayListIterator<E> implements Iterator<E>{
        int cur;

        @Override
        public boolean hasNext() {
            if(cur<ArrayList.this.size()){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return (E)ArrayList.this.buffer[cur++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(cur-1);
            cur--;
        }
    }
}
