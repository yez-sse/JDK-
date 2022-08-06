package problem.lc.lc3;

import java.util.Arrays;

public class P204计算质数 {

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                //从i * i开始，能够避免重复计算？？
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count ++;
            }
        }
        return count;
    }
}
