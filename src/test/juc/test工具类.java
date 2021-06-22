package test.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class test工具类 {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集第" + temp + "个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }



//        CountDownLatch countDownLatch = new CountDownLatch(6);
//
//        for (int i = 0; i < 6; i++) {
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName() + "leaves");
//            }, String.valueOf(i)).start();
//        }
//
//        //countDownLatch.countDown();  // 等待计数器归零，即上面6个线程都执行完了，才能继续往下走
//
//        System.out.println("Close the door");
    }
}
