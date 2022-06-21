package problem.lc.lc1;

import java.util.Arrays;

public class P56合并区间and数组 {
    public int[][] mergeArrays(int[][] intervals) {
        //先按起始位置排序！！
        //二维数据排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);  //从小到大
        //这题需要画图，画出图之后还需要总结，怎么能统一概括
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int resLength = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > res[resLength][1]) {
                res[++resLength] = intervals[i];
            } else {
                res[resLength][1] = Math.max(res[resLength][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(res, resLength+1);
    }
}
