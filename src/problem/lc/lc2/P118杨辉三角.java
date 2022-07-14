package problem.lc.lc2;

import java.util.ArrayList;
import java.util.List;

public class P118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1) {
            return res;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 2; j < i; j++) {
                path.add(last.get(j - 2) + last.get(j - 1));
            }
            path.add(1);
            res.add(path);
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(1);
            for (int j = 2; j < i + 1; j++) {
                path.add(res.get(j - 2) + res.get(j - 1));
            }
            path.add(1);
            res = path;
        }
        return res;
    }
}
