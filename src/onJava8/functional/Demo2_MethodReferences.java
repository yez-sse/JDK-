package onJava8.functional;

interface Callable {
    void call(String s);
} // [1]

class Describe {
    void show(String msg) { // [2]
        System.out.println(msg);
    }
}

public class Demo2_MethodReferences {
    static void hello(String name) { // [3]
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) { // [4]
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) { // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show; // [6]
        c.call("call()"); // [7]
        c = Demo2_MethodReferences::hello; // [8]
        c.call("Bob");
        c = new Description("valuable")::help; // [9]
        c.call("information");
        c = Helper::assist; // [10]
        c.call("Help!");
    }
}

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

class Practice2 {
    public static void main(String[] args) {
        new Thread(Go::go).start();
        // 或者在使用mybatis-plus中会用到
//        wrapper.lambda().equals(user::getName(), name);
    }
}

