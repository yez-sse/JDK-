package test.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testCondition {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.printC();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.printA();
            }
        }, "A").start();
    }
}

class Data {  // 资源类
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private int num = 1;  // 1A  2B  3C

    public void printA() {
        lock.lock();
        try {
            // 业务，判断 -- 执行 -- 通知
            while (num != 1) {
                // 等待
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "  A");
            num++;
            // 唤醒指定的人B
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            // 业务，判断 -- 执行 -- 通知
            while (num != 2) {
                // 等待
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "  B");
            num++;
            // 唤醒指定的人C
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 业务，判断 -- 执行 -- 通知
            while (num != 3) {
                // 等待
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "  C");
            num -= 2;
            // 唤醒指定的人A
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
