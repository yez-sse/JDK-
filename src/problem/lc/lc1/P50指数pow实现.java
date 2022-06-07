package problem.lc.lc1;

public class P50指数pow实现 {
//    public double myPow(double x, int n) {
//        if (x == 1.0) {
//            return x;
//        }
//        if (n < 0) {
//            x = 1.0/x;
//            if (n == Integer.MIN_VALUE) {
//                n = Integer.MAX_VALUE;
//            } else {
//                n = -n;
//            }
//        }
//        double res = 1.0;
//        for (int i = 0; i < n; i++) {
//            res = res * x;
//        }
//        return res;
//    }
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n; //这样就能很方便的解决-n溢出的问题
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            //这几行代码是精妙啊，位运算，幂次方，很快很快啊
            if ((b & 1) == 1) {
                res *= x;
            }
            x = x * x;
            b >>= 1;
        }
        return res;
    }
}
