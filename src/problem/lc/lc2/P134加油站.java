package problem.lc.lc2;

public class P134加油站 {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % gas.length;
    }

    //下面是人家写的暴力，暴力都不会写，怎么办哦
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i];
            int j = i;
            while(remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % gas.length];
                j = (j + 1) % gas.length;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    //这写了半天写了个寂寞
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 1; i <= gas.length; i++) {
//            boolean can = true;
//            int tempGas = gas[i - 1];
//            int idx = i;
//            while (idx <= i + gas.length) {
//                if (idx > gas.length) {
//                    idx -= gas.length;
//                }
//                tempGas -= cost[idx - 1];
//                if (tempGas < 0) {
//                    can = false;
//                    break;
//                }
//                if (idx >= gas.length) {
//                    tempGas += gas[idx - gas.length];
//                } else {
//                    tempGas += gas[idx - 1];
//                    idx++;
//                }
//            }
//            if (can) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
