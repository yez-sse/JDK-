package Thread.producer_consumer;

import java.util.LinkedList;

public class Synchronized实现 {
}

class Storage {
    private final int MAX_SIZE = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public void produce() throws InterruptedException {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("Full.");
                //Synchronized是和wait、notifyAll一起用的
                list.wait();
            }
            list.addLast(new Object());
            System.out.println(Thread.currentThread().getName() + " produce. Now " + list.size());
            list.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("Empty.");
                list.wait();
            }
            list.removeFirst();
            System.out.println(Thread.currentThread().getName() + " consume. Now " + list.size());
            list.notifyAll();
        }
    }
}

class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Consumer(storage));
        Thread p4 = new Thread(new Consumer(storage));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
