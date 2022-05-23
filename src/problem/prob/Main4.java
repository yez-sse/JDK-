package problem.prob;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if (m * n < 6 || m < 2 || n < 2) {
            System.out.println(0);
        }
        if (m * n % 6 == 0) {
            System.out.println(m * n % 6);
        }
        int temp = m > n ? m : n;
        n = m < n ? m : n;
        m = temp;
        int ans = (m / 3) * (n / 2) + (m % 3) / 2 * (n / 3);
        System.out.println(ans);
    }
}
