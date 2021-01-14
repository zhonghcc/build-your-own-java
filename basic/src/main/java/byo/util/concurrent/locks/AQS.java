package byo.util.concurrent.locks;

import byo.util.UnsafeUtil;
import sun.misc.Unsafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQS {
    private volatile AQSNode head;
    private volatile AQSNode tail;

    private static final long headOffset;
    private static final long tailOffset;
    private static final Unsafe unsafe = UnsafeUtil.getUnsafe();

    static {
        try {
            headOffset = unsafe.objectFieldOffset
                    (AQS.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (AQS.class.getDeclaredField("tail"));

        } catch (Exception ex) { throw new Error(ex); }
    }

    private AQSNode addWaiter(){
        AQSNode node = new AQSNode(Thread.currentThread());
        enq(node);
        return node;
    }

    private AQSNode enq(AQSNode node){
        while(true){
            AQSNode tail = this.tail;
            if(tail==null){
                if(casHead(new AQSNode())){
                    tail = head;
                }
            }else{
                node.prev = tail;
                if(casTail(tail,node)){
                    tail.next=node;
                    return tail;
                }
            }
        }
    }

    private boolean casHead(AQSNode head){
        return unsafe.compareAndSwapObject(this,headOffset,null,head);
    }

    private boolean casTail(AQSNode tail,AQSNode newTail){
        return unsafe.compareAndSwapObject(this,tailOffset,tail,newTail);
    }
}
