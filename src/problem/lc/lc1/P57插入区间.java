package problem.lc.lc1;

import java.util.ArrayList;
import java.util.Arrays;

public class P57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int[][] res = new int[intervals.length+1][2];
//        int idx = 0;
//        if (newInterval[1] < intervals[0][0]) {
//            res[idx++] = newInterval;
//        }
//        for (int i = 0; i < intervals.length; i++) {
//            if ((intervals[i][0] - newInterval[0]) * (intervals[i][1] - newInterval[1]) <= 0) {
//                int[] merge = new int[2];
//                merge[0] = Math.min(newInterval[0], intervals[i][0]);
//                while (i < intervals.length) {
//                    if (intervals[i][0] <= newInterval[1]) {
//                        merge[1] = Math.max(intervals[i][1], newInterval[1]);
//                    }
//                }
//                res[idx++] = merge;
//            } else {
//                res[idx++] = intervals[i];
//            }
//        }
//        if (newInterval[0] > intervals[intervals.length - 1][1]) {
//            res[idx++] = newInterval;
//        }
//        return Arrays.copyOf(res, idx);

        ArrayList<int[]> res = new ArrayList<>();
        int idx = 0;

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(intervals[idx++]);
        }

        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        res.add(newInterval);

        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[0][]);
    }
}
