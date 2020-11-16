package byo.util.concurrent;

import byo.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountDownLatchTest {
    @Test
    public void testCountDownLatch(){
        int CASE_SUM = 40;
        CountDownLatch countDownLatch = new CountDownLatch(CASE_SUM);
        AtomicInteger total = new AtomicInteger(0);
        for(int i=0;i<CASE_SUM;i++){
            new Thread(()->{
                total.getAndIncrease(1);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        Assert.assertEquals(CASE_SUM,total.get());
    }
}