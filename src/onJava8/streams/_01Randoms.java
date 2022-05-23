package onJava8.streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class _01Randoms {
    public static void main(String[] args) {
        new Random(47)
                .ints(100, 200)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }

    public static void imperativeRandom() {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt();
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
