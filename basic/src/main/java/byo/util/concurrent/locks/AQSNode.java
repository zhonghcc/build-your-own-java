package byo.util.concurrent.locks;

public class AQSNode {
    AQSNode prev;
    AQSNode next;
    Thread thread;

    /** waitStatus value to indicate thread has cancelled */
    static final int CANCELLED =  1;
    /** waitStatus value to indicate successor's thread needs unparking */
    static final int SIGNAL    = -1;
    /** waitStatus value to indicate thread is waiting on condition */
    static final int CONDITION = -2;
    /**
     * waitStatus value to indicate the next acquireShared should
     * unconditionally propagate
     */
    static final int PROPAGATE = -3;

    volatile int waitStatus;

    AQSNode(Thread thread){
        this.thread = thread;
    }

    AQSNode() {    // Used to establish initial head or SHARED marker
    }
}
