package byo.util.container;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void size() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(0,arrayList.size());

        arrayList.add(1);
        Assert.assertEquals(1,arrayList.size());
        for(int i=0;i<7;i++){
            arrayList.add(i);
        }
        Assert.assertEquals(8,arrayList.size());
        for(int i=0;i<33;i++){
            arrayList.add(i);
        }
        Assert.assertEquals(41,arrayList.size());

    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void iterator() {
    }
}