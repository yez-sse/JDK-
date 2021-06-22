package test.juc;

import jdk.nashorn.internal.runtime.StoredScript;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCustomer {
    public static void main(String[] args) {
        Store store = new Store();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                store.increase();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                store.decrease();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                store.increase();
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                store.decrease();
            }
        }, "D").start();
    }
}

// 判断等待，业务，通知
class Store {

    private int num = 5;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            // 业务代码
            while (num != 0) {
                // 等待
                condition.await();
            }
            // 干活
            num++;
            System.out.println(Thread.currentThread().getName() + " " + num);
            // 通知其他线程，我干完活了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try {
            // 业务代码
            while (num == 0) {
                // 等待
                condition.await();
            }
            // 干活
            num--;
            System.out.println(Thread.currentThread().getName() + " " + num);
            // 通知其他线程，我干完活了
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
