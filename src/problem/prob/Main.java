package problem.prob;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");

        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss[i].length(); j++) {
                if (ss[i].charAt(j) == 'e' || ss[i].charAt(j) == 'E') {
                    res++;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String[] ss = s.split(",");
//        int[] ns = new int[ss.length];
//        for (int i = 0; i < ss.length; i++) {
//            ns[i] = Integer.parseInt(ss[i]);
//        }
//        int[] dp = new int[ss.length];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i < ss.length; i++) {
//            dp[i] = dp[i - 1] + 1;
//            int idx = i - 1;
//            while (idx >= 0) {
//                if (ns[i] == ns[idx]) {
//                    dp[i] = Math.min(dp[i], dp[idx] + 1);
//                    break;
//                }
//                idx--;
//            }
//            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
//        }
//        System.out.println(dp[ss.length - 1]);
//    }
}





































