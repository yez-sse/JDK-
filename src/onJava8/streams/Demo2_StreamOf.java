package onJava8.streams;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Demo2_StreamOf {
    public static void main(String[] args) {
//        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3))
//                .forEach(System.out::println);
//        Stream.of("It's ", "a ", "wonderful ", "day ", "for ", "pie!")
//                .forEach(System.out::print);
//        System.out.println();
//        Stream.of(3.14159, 2.718, 1.618)
//                .forEach(System.out::println);


//        List<Bubble> bubbles =
//                Arrays.asList(new Bubble(1),new Bubble(2), new Bubble(3));
//        System.out.println();
//        Set<String> w =
//                new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
//        w.stream()
//                .map(x -> x + " ")
//                .forEach(System.out::print);
//        System.out.println();
//        Map<String, Double> m = new HashMap<>();
//        m.put("pi", 3.14159);
//        m.put("e", 2.718);
//        m.put("phi", 1.618);
//        m.entrySet().stream()
//                .map(e -> e.getKey() + ": " + e.getValue())
//                .forEach(System.out::println);


        // 传统方法:
        int result = 0;
        for (int i = 10; i < 20; i++)
            result += i;
        System.out.println(result);
        // for-in 循环:
        result = 0;
        for (int i : range(10, 20).toArray())
            result += i;
        System.out.println(result);
        // 使用流:
        System.out.println(range(10, 20).sum());

    }
}

class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20) // 过滤前 20 个
                .limit(10) // 然后取 10 个
                .forEach(System.out::println);
    }
}

