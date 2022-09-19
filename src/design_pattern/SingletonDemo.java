package design_pattern;

public class SingletonDemo {
    
    private volatile static SingletonDemo singleton;

    private SingletonDemo() {}

    // 懒汉式 + 双重校验
    public static SingletonDemo getInstance() {
        if (singleton == null) {
            synchronized (SingletonDemo.class) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }
}
