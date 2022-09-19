package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P合并区间 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        int idx = 0;
        List<int[]> list = new ArrayList<>();
        while (idx < intervals.length) {
            int[] temp = new int[2];
            temp[0] = intervals[idx][0];
            int end = intervals[idx][1];
            while (idx < intervals.length - 1 && end >= intervals[idx + 1][0]) {
                end = Math.max(end, intervals[idx + 1][1]);
                idx++;
            }
            temp[1] = end;
            list.add(temp);
            idx++;
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
