package test.juc;

import java.util.concurrent.Callable;

public class testCallable {
    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.call();
    }
}

class MyThread implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}
