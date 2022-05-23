package onJava8.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        Stream.of("It's ", "a ", "wonderful ", "day")
                .forEach(System.out::print);
        System.out.println();
        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day".split(" ")));
        w.stream()
                // 中间操作 map() 会获取流中的所有元素，并且对流中元素应用操作从而产生新的元素，并将其传递到后续的流中。
                .map(x -> x + " ")
                .forEach(System.out::print);
    }

    public static <T> void show(Stream<T> stream) {
        stream.limit(4)
                .forEach(System.out::println);
    }
}
