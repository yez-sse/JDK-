package Thread;

public class PrintABC {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}

class MyThread implements Runnable {

    private static volatile int flag = 0;

    @Override
    public void run() {
        synchronized (this) {
            if (flag == 0) {
                System.out.println(Thread.currentThread().getName() + "A");
            } else if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "B");
            } else if (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "C");
            }
            flag++;
            // 甚至都不用notify？？
//            this.notifyAll();
        }
    }
}
