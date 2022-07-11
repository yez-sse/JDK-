package problem.lc.unresolve;

import java.util.ArrayList;
import java.util.List;

public class P89格雷码 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0); //init
        for (int i = 1; i < 1 << n; i ++) {
            int previous = res.get(i - 1);
            if (i % 2 == 1) {
                previous ^= 1; //和000001 做异或，使最后一边取反
            }
        }
        return res;
    }
}
