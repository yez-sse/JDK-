package problem.lc.lc2;

import java.util.ArrayDeque;
import java.util.Deque;

public class P150逆波兰表达式求值_栈 {

    public static void main(String[] args) {
        String[] ts = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(ts));
    }

    public static int evalRPN(String []tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y + x);
            } else if (tokens[i].equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if (tokens[i].equals("*")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y * x);
            } else if (tokens[i].equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}
