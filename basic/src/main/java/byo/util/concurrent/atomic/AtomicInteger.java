package byo.util.concurrent.atomic;

import byo.util.UnsafeUtil;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

@Slf4j
public class AtomicInteger{
    private static final Unsafe unsafe = UnsafeUtil.getUnsafe();
    private static long offset;
    private volatile int value;

    static {
        try{
            offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));

        }catch (Exception e){
            log.error("load offset error",e);
            throw new Error(e);
        }
    }
    public AtomicInteger(int init){
        this.value = init;
    }

    public int getAndIncrease(int delta){
        return unsafe.getAndAddInt(this,offset,delta);
    }
    public boolean compareAndSet(int expect,int update){
        return unsafe.compareAndSwapInt(this,offset,expect,update);
    }
    public int get(){
        return value;
    }
}
