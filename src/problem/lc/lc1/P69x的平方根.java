package problem.lc.lc1;

public class P69x的平方根 {

    public static void main(String[] args) {
        System.out.println(289398 * 289398);
        System.out.println(46340 * 46340);
        System.out.println(46341 * 46341);
        System.out.println(mySqrt(2147395600));
    }

    public static int mySqrt(int x) {
        int i = 0;  //就是暴力法也有要主义的，这个
        while (i * i <= x) {
            if ((i + 1) * (i + 1) > x) {
                return i;
            }
            i++;
        }
        return i;
    }

    //这题还能用二分查找，这个应该也要能比较自然的想到的
    public int mySqrt2(int x) {
        int left = 1;
        int right = x / 2;
        while (left < right) {
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        // int right = x / 2;
        int right = x;
        while (left <= right) { //这里要是<=，下面就是一个+1，一个-1。这样不会有溢出
            int mid = (left + right) / 2;   //这里就直接相加然后除2
            if (mid <= x / mid) {   //这里根据情况选择right还是left-1，最后出来一定left在right右边一个，而right在正好的位置？
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return left-1;
    }
}
