package problem.prob;

import java.util.*;

public class Main {

//    public static void main(String[] args) {
//
//        int[] nums = new int[]{6,9,9,9,6};
//        System.out.println(maxLen(nums));
//    }
//
//    public static int maxLen(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 8) {
//                dp[i][i] = 1;
//            } else {
//                dp[i][i] = -1;
//            }
//        }
//        int max = 0;
//        for (int j = 1; j < nums.length; j++) {
//            for (int i = 0; i + j < nums.length; i++) {
//                dp[i][i + j] = dp[i][i + j - 1] + nums[j] > 8 ? 1 : -1;
//                if (dp[i][j] > 0) {
//                    max = j + 1;
//                }
//            }
//        }
//        return max;
//    }


//    private static int maxSum = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        dfs(n, nums, 1, 0);
//        System.out.println(maxSum);
//    }
//
//    public static void dfs(int n, int[] nums, int idx, int sum) {
//        if (idx > n) {
//            return;
//        }
//        sum += nums[idx - 1];
//        if (sum > maxSum) {
//            maxSum = sum;
//        }
//        dfs(n, nums, 2 * idx, sum);
//        dfs(n, nums, 2 * idx + 1, sum);
//        sum -= nums[idx - 1];
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        Map<String, HashSet<String>> m = new HashMap<>();
//        while (n-- > 0) {
//            String s = in.nextLine();
//            String[] ss = s.split(" ");
//            if (ss[0].equals("1")) {
//                String s2 = in.nextLine();
//                String[] s2s = s2.split(" ");
//                HashSet<String> set = new HashSet<>();
//                for (int i = 0; i < s2s.length; i++) {
//                    set.add(s2s[i]);
//                }
//                m.put(ss[1], set);
//            } else {
//                if (!m.keySet().contains(ss[1])) {
//                    System.out.println("error");
//                } else {
//                    int res = 0;
//                    HashSet<String> temp = new HashSet<>();
//                    for (String key : m.get(ss[1])) {
//                        temp.add(key);
//                    }
//                    for (String key : m.get(ss[1])) {
//                        for (String key2 : m.keySet()) {
//                            if (!key2.equals(ss[1])) {
//                                if (m.get(key2).contains(key)) {
//                                    for (String key3 : m.get(key2)) {
//                                        if (!temp.contains(key3)) {
//                                            temp.add(key3);
//                                            res++;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    System.out.println(res);
//                }
//            }
//        }
//    }



}





































