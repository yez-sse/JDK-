package test.juc;

import java.util.TreeMap;

public class TicketSale {
    public static void main(String[] args) {
        // 并发：多个线程操作同一个资源类，把资源丢入线程
        Ticket ticket = new Ticket();

        new Thread(new Runnable() { // 函数式接口，匿名内部类实现
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();

        new Thread(()->{  // lambda表达式，代码写在大括号里
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(()->{ticket.sale();}, "C").start();

        new Thread(ticket::sale, "D").start();
    }
}

class Ticket {
    private int number = 50;

    public synchronized void sale() {
        System.out.println(
                Thread.currentThread().getName() + " " + number--
        );
    }
}
