package test.juc;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class testConcurrentHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                //System.out.println(UUID.randomUUID().toString().substring(0, 5));
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
            }, String.valueOf(i)).start();
        }
    }
}
