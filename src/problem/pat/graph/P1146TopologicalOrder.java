package problem.pat.graph;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;

public class P1146TopologicalOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] inDegree = new int[1010];
        Map<Integer, List<Integer>> map = new HashMap<>(1010);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (map.get(a) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            } else {
                map.get(a).add(b);
            }
            inDegree[b]++;
        }

        int k = in.nextInt();
        boolean isFirst = true;
        for (int i = 0; i < k; i++) {
            boolean isT = true;
            int[] temp = new int[1010];
            temp = inDegree;
            for (int j = 0; j < n; j++) {
                int a = in.nextInt();
                if (temp[a] != 0) {
                    isT = false;
                    break;
                }
                for (int it : map.get(a)) {
                    temp[it]--;
                }
            }
            if (isT) {
                continue;
            }
            System.out.println("不行");
            isFirst = false;
        }
    }
}
