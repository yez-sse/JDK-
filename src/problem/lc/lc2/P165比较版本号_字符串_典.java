package problem.lc.lc2;

import java.util.LinkedList;

public class P165比较版本号_字符串_典 {


    public int compareVersion2(String version1, String version2) {
        String[] vs1 = version1.split("\\.");   //为什么不直接是. 这里要学正则表达式啊
        String[] vs2 = version2.split("\\." );
        int len1 = vs1.length;
        int len2 = vs2.length;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < len1 || idx2 < len2) {
            int num1 = 0;
            int num2 = 0;
            if (idx1 < len1) {
                num1 = Integer.parseInt(vs1[idx1++]);
            }
            if (idx2 < len2) {
                num2 = Integer.parseInt(vs2[idx2++]);
            }
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }



    //这下面写的什么乱七八糟的，真是看看人家三叶写的，自己咋就写的这么像民工呢
    public int compareVersion(String version1, String version2) {

        String vs1 = getVersion(version1);
        String vs2 = getVersion(version2);

        return -1;
    }

    public String getVersion(String version) {
        char[] vs = version.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < vs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(vs[i]);
                continue;
            }
            if (stack.peek() == 0) {
                if (vs[i] != '0') {
                    stack.pop();
                }
                stack.push(vs[i]);
                continue;
            }
            stack.push(vs[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
