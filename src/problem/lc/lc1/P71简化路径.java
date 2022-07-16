package problem.lc.lc1;

import java.nio.file.Paths;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class P71简化路径 {

    public static void main(String[] args) {
        String path = "/home//foo/";
        simplifyPath(path);
    }

    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!strs[i].equals("") && !strs[i].equals(".")) {
                stack.push(strs[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            builder.append("/" + stack.getLast());
            stack.removeLast();
        }
        return builder.toString();
    }


    //9/257，这个答案可以说是一文不值
    public String SimplifyPath_Fault(String path) {
        char[] chars = path.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                if (chars[i] == '/') {
                    stack.push(chars[i]);
                }
            } else {
                if (chars[i] == '/') {
                    if (stack.peek() == '.') {
                        stack.pop();
                        stack.pop();
                        stack.push(chars[i]);
                    } else if (stack.peek() != '/') {
                        stack.push(chars[i]);
                    }
                } else if (chars[i] == '.') {
                    if (stack.peek() == '.') {
                        stack.pop();
                        stack.pop();
                        if (stack.size() > 0) {
                            stack.pop();
                        }
                    } else {
                        stack.push(chars[i]);
                    }
                } else {
                    stack.push(chars[i]);
                }
            }
        }
        if (stack.peek() == '/' && stack.size() > 1) {
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();
        for (Iterator<Character> it = stack.iterator(); it.hasNext(); ) {
            builder.append(it.next());
        }
        return builder.reverse().toString();
    }
}
