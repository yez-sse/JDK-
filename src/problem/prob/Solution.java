package problem.prob;
import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
}


public class Solution {

    int res = 0;

    public int findIflytek (String str) {
        // write code here

        char[] cs = str.toCharArray();
        boolean[] visited = new boolean[cs.length];
        Deque<Character> path = new ArrayDeque<>();
        dfs(cs, 0, visited, path);
        return res;
    }

    public void dfs(char[] cs, int begin, boolean[] visited, Deque<Character> path) {
        if (path.size() == 6) {
            res++;
            return;
        }
        for (int i = begin; i < cs.length; i++) {
            if (visited[i]) {
                return;
            }
            visited[i] = true;
            boolean flag = false;
            if (path.size() == 0 && (cs[i] == 'i' || cs[i] == 'I')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 'i' || path.peek() == 'I') && (cs[i] == 'f' || cs[i] == 'F')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 'f' || path.peek() == 'F') && (cs[i] == 'l' || cs[i] == 'L')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 'l' || path.peek() == 'L') && (cs[i] == 'y' || cs[i] == 'Y')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 'y' || path.peek() == 'Y') && (cs[i] == 't' || cs[i] == 'T')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 't' || path.peek() == 'T') && (cs[i] == 'e' || cs[i] == 'E')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (path.size() > 0 && (path.peek() == 'e' || path.peek() == 'E') && (cs[i] == 'k' || cs[i] == 'K')) {
                path.push(cs[i]);
//                dfs(cs, begin + 1, visited, path);
                dfs(cs, i + 1, visited, path);
                flag = true;
            }
            if (flag) {
                path.pop();
            }
            visited[i] = false;
        }
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求四个点的面积
     * @param p1 Point类 点1
     * @param p2 Point类 点2
     * @param p3 Point类 点3
     * @param p4 Point类 点4
     * @return long长整型
     */
    public long getArea (Point p1, Point p2, Point p3, Point p4) {
        // write code here
//        int[] x = new int[4];
//        int[] y = new int[4];
//
//        x[0] = p1.x;
//        x[1] = p2.x;
//        x[2] = p3.x;
//        x[3] = p4.x;
//
//        y[0] = p1.y;
//        y[1] = p2.y;
//        y[2] = p3.y;
//        y[3] = p4.y;

        long l1 = p1.x * p2.y + p2.x * p3.y + p3.x * p4.y + p4.x * p1.y;
        long l2 = p2.x * p1.y + p3.x * p2.y + p4.x * p3.y + p1.x * p4.y;
        long sub = Math.abs(l1 - l2);
        return Math.round(sub * 0.5);
    }
}
