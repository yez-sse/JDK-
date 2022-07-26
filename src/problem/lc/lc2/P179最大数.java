package problem.lc.lc2;

import java.util.Arrays;

public class P179最大数 {

    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }


    //30比3大，字符串比较就有问题
    public String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length; i >= 0; i--) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
