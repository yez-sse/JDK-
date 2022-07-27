package problem.struct;

public class UnionFind2 {

    int count;
    int[] parent;

    public int getCount() {
        return count;
    }

    public UnionFind2(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }
}
