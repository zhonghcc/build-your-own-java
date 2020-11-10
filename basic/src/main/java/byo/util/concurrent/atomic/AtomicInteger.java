package byo.util.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AtomicInteger{
    int i;
    public AtomicInteger(int init){
        this.i = init;
    }

    public int getAndIncrease(int delta){
        log.info("getAndIncrease {}",delta);
        int ret = i;
        i+=delta;
        return ret;
    }
    public int get(){
        return i;
    }
}
