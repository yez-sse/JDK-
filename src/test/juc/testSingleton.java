package test.juc;

//class Hungry {还有懒汉式，加了双重锁之后的懒汉式，都有问题
//    // 饿汉式一上来加载全部内容，耗内存
//    private Long[] data = new Long[1024 * 1024];
//
//    private Hungry() {
//
//    }
//
//    private final static Hungry hungry = new Hungry();
//
//    public static Hungry getHungry() {
//        return hungry;
//    }
//}

public class testSingleton {

    private volatile static testSingleton singleton;

    private testSingleton() {

    }

    public testSingleton getSingleton() {
        if (singleton == null) {
            synchronized (testSingleton.class) {
                if (singleton == null) {  // 双重检测机制 + volatile可见性保障原子性操作？？
                    singleton = new testSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
