package problem.prob;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.nextLine().toCharArray();
        int len = cs.length;
        int res = cs.length;

        char [][] c = new char[len][len];
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            c[i][i] = cs[i];
        }
        for (int L = 1; L <= len / 2; L++) {
            for (int i = L; i < len - L; i++) {
                if (cs[i - L] == cs[i + L]) {
                    if (dp[i - L + 1][i + L - 1]) {
                        res++;
                        dp[i - L][i + L] = true;
                        c[i - L][i + L] = c[i - L + 1][i + L - 1];
                        continue;
                    }
                } else {
                    if (dp[i - L + 1][i + L - 1]) {
                        if (c[i - L + 1][i + L - 1] == cs[i - L]) {
                            res++;
                            System.out.println(i);
                            System.out.println(L);
                            System.out.println(i - L + 1);
                            System.out.println(i + L - 1);
                            System.out.println(c[i - L + 1][i + L - 1]);
                            System.out.println(cs[i - L]);
                            System.out.println(12);
                            dp[i - L][i + L] = true;
                            c[i - L][i + L] = cs[i + L];
                            continue;
                        }
                        if (c[i - L + 1][i + L - 1] == cs[i + L]) {
                            res++;
                            System.out.println(22);
                            dp[i - L][i + L] = true;
                            c[i - L][i + L] = cs[i + L];
                            continue;
                        }
                    } else {
                        Set<Character> set = new HashSet<>();
                        for (int j = i - L; j <= i + L; j++) {
                            if (set.contains(cs[j])) {
                                set.remove(cs[j]);
                            } else {
                                set.add(cs[j]);
                            }
                        }
                        if (set.size() == 1) {
                            res++;
                            System.out.println(3);
                            dp[i - L][i + L] = true;
                            c[i - L][i + L] = set.iterator().next();
                            continue;
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
}