package byo.util.container;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

@Slf4j
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
    public void remove() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<7;i++){
            arrayList.add(i);
        }
        arrayList.remove(3);
//        log.info("{}",arrayList);
        Assert.assertEquals(4,arrayList.get(3).intValue());
        Assert.assertEquals(6,arrayList.size());
    }


    @Test
    public void iterator() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<7;i++){
            arrayList.add(i);
        }
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            log.info("{}",iterator.next());
        }
        Iterator<Integer> ite2 = arrayList.iterator();
        while(ite2.hasNext()){
            Integer value = ite2.next();
            if(value==3){
                ite2.remove();
            }else{
                log.info("{}",value);
            }
        }
        Assert.assertEquals(6,arrayList.size());
    }
}