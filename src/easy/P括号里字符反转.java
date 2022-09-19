package easy;

import java.util.Deque;
import java.util.LinkedList;

public class P括号里字符反转 {

    public static void main(String[] args) {
        System.out.println(reverse("(i(u(wa)e)h)"));
    }

    public static String reverse(String s) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ')') {
                LinkedList<Character> tempStack = new LinkedList<>();
                while (stack.peek() != '(') {
                    tempStack.push(stack.pop());
                }
                stack.pop();
                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pollLast());
                }
            } else {
                stack.push(cs[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
