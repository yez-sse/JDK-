package problem.pat.graph;

import java.util.*;

class Node1154 {
    int e1;
    int e2;

    public Node1154() {}

    public Node1154(int e1, int e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}

public class P1154VertexColoring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Node1154> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Node1154 tempNode = new Node1154();
            tempNode.e1 = in.nextInt();
            tempNode.e2 = in.nextInt();
            list.add(tempNode);
        }

        int k = in.nextInt();
        while (k-- > 0) {
            int[] a = new int[10009];
            boolean flag = true;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                set.add(a[i]);
            }
            for (int i = 0; i < m; i++) {
                if (a[list.get(i).e1] == a[list.get(i).e2]) {
                    flag = false;
                    break;
                }
            }
        }
    }
}
