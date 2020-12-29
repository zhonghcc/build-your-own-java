package byo.util.container;

public interface Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(E o);
    boolean add(E e);
    boolean remove(E o);
    void clear();
}
