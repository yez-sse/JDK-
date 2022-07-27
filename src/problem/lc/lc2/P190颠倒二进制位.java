package problem.lc.lc2;

public class P190颠倒二进制位 {

    // you need treat n as unsigned
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (32 - i);
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }
}
