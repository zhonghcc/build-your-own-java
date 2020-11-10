package byo.util.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class AtomicIntegerTest {

    @Test
    public void getAndIncrease() {
        final AtomicInteger i = new AtomicInteger(0);
        for(int j=0;j<100;j++){
            new Thread(()->{
                log.info("current={}",i.getAndIncrease(1));
            }).start();
        }
        Assert.assertEquals(100,i.get());
    }
}