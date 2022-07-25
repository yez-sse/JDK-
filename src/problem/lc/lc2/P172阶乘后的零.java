package problem.lc.lc2;

public class P172阶乘后的零 {

    public int trailingZeros(int n) {
//        return n / 5;   //这个就没有考虑25、125这样的情况
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
