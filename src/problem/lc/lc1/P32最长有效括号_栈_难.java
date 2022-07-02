package problem.lc.lc1;

import java.util.Deque;
import java.util.LinkedList;

public class P32最长有效括号_栈_难 {

    public static void main(String[] args) {
        String s = "(()";
        longestValidParentheses(s);
    }

    //这个我写的，对于"()(()"这种要动态规划就不行，156/231也就是说远远不够
    public static int longestValidParentheses(String s) {
        int max = 0;
        int temp = 0;
        Deque<Character> stack = new LinkedList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty() || stack.getLast() != '(') {
                    max = Math.max(max, temp);
                    temp = 0;
                    stack.clear();
                } else {
                    stack.removeLast();
                    temp++;
                }
            }
        }
        return max;
    }
}
