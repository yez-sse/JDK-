package problem.pat.tree.dfs;

import java.util.*;

class Node1102 {
    int id;
    int left;
    int right;
    int index;
    int level;

    public Node1102() {}

    public Node1102(int id, int left, int right, int index, int level) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.index = index;
        this.level = level;
    }
}

public class P1102InvertBinaryTree {

    private static Node1102[] nodes = new Node1102[100];
    private static List<Node1102> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        //不在左右子节点中的就是根
        int[] have = new int[100];

        for (int i = 0; i < n; i++) {
            Node1102 tempNode = new Node1102();
            tempNode.id = i;
            String[] sub = in.nextLine().split(" ");
            if (sub[0] != "-") {
                int l = Integer.parseInt(sub[0]);
                tempNode.left = l;
                have[l] = 1;
            } else {
                tempNode.left = -1;
            }
            if (sub[1] != "-") {
                int r = Integer.parseInt(sub[1]);
                tempNode.right = r;
                have[r] = 1;
            } else {
                tempNode.right = -1;
            }
            nodes[i] = tempNode;
        }
        //从0开始的，总之就是审题
        int root = 0;
        while (have[root] == 1) {
            root++;
        }
        dfs(root, 0, 0);

        Collections.sort(list, (a, b) -> {
            if (a.level != b.level) {
                return a.level - b.level;
            }
            //??
            return b.index - a.index;
        });
    }

    public static void dfs(int root, int index, int level) {
        if (nodes[root].right != -1) {
            dfs(nodes[root].right, index * 2 + 2, level + 1);
        }
        list.add(new Node1102(root, 0, 0, index, level));
        if (nodes[root].left != -1) {
            dfs(nodes[root].left, index * 2 + 1, level + 1);
        }
    }
}
