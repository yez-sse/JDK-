package problem.lc.lc4;

import java.util.LinkedList;

public class P394字符串解码 {

    // 辅助栈法
    public String decodeString(String s) {

        StringBuilder cur = new StringBuilder();
        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_str = new LinkedList<>();

        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack_num.addLast(num);
                stack_str.addLast(cur.toString());
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                int latestNum = stack_num.removeLast();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < latestNum; i++) {
                    temp.append(cur);
                }
                cur = new StringBuilder(stack_str.removeLast() + temp);
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
