package problem.prob;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int left = k % 2;
        k = k % 2 == 0 ? k : k - 1;
        int[] fib = new int[m + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= m; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(k * fib[m] + left);
    }
}
