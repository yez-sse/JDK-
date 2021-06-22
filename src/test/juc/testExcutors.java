package test.juc;

import java.util.concurrent.*;

public class testExcutors {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5,
                3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            // 最大承载 maxPoolSize + BlockingQueueCapacity，最多5个窗口开着加上3个人等着
            // 超出8个人会抛异常，被拒绝策略的异常
            for (int i = 0; i < 9; i++) {
                // excute方法里面的参数就是一个线程，这里是一个lambda表达式
                threadPoolExecutor.execute(() -> {  // 用这种线程池的方式创建执行一个线程
                    System.out.println(Thread.currentThread().getName() + " threadPoolExecutor");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();  // 线程池用完一定要关闭
        }



        // 不建议这么写，直接用原生的ThreadPoolExecutor

        ExecutorService cached = Executors.newCachedThreadPool(); //来多少收多少
        // core-0，max-整数最大值；core-1，max-1
        ExecutorService single = Executors.newSingleThreadExecutor();  // 只有单个线程
        try {
            for (int i = 0; i < 5; i++) {
                single.execute(() -> {  // 用这种线程池的方式创建执行
                    System.out.println(Thread.currentThread().getName() + " single");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            single.shutdown();
        }

        // core-5，max-5，固定线程数
        ExecutorService fixed = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 5; i++) {
                single.execute(() -> {  // 用这种线程池的方式创建执行
                    System.out.println(Thread.currentThread().getName() + " fixed3");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixed.shutdown();
        }
    }
}
