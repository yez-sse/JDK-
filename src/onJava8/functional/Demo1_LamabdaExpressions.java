package onJava8.functional;

import java.util.Arrays;
import java.util.List;

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class Demo1_LamabdaExpressions {
    static Body bod = h -> h + " No Parens!"; // [1]
    static Body bod2 = (h) -> h + " More details"; // [2]
    static Description desc = () -> "Short info"; // [3]
    static Multi mult = (h, n) -> h + n; // [4]
    static Description moreLines = () -> { // [5]
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}

class Practice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 遍历
        numbers.forEach(x -> System.out.println(x));
        // 排序
        numbers.sort((x1, x2) -> x1 - x2);
        // 线程
        Thread t = new Thread(() -> System.out.println("hello"));
        // Stream对象的map、reduce方法
        System.out.println(numbers.stream()
                .map(x -> x * 2).reduce((x, y) -> x + y).get());
    }
}

