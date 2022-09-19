package Thread.producer_consumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock实现 {
}

class Storage2 {
    private final int MAX_SIZE = 0;
    private LinkedList<Object> list = new LinkedList<>();
    //锁
    private final Lock lock = new ReentrantLock();
    //仓库满条件变量？
    private final Condition full = lock.newCondition();
    //仓库空条件变量
    private final Condition empty = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        while (list.size() + 1 > MAX_SIZE) {
            System.out.println("full.");
            // lock中用condition来实现同步操作，await和signalAll方法
            full.await();
        }
        list.add(new Object());
        System.out.println(Thread.currentThread().getName() + " produce. Now " + list.size());
        // 两个condition把生产和消费分开了
        full.signalAll();
        lock.unlock();
    }
}
