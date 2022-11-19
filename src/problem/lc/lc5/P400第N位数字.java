package problem.lc.lc5;

public class P400第N位数字 {

    public int findNthDigit(int n) {
        int numWidth = 1;
        int base = 9;
        while (n > (long) numWidth * base) {
            n -= numWidth * base;
            numWidth++;
            base *= 10;
            // handle integer overflow, base * numWidth > MAX_VALUE
//            if (Integer.MAX_VALUE / base < numWidth) {
//                break;
//            }
        }

        int num = (int) Math.pow(10, numWidth - 1) + n / numWidth - 1;
        if (n % numWidth == 0) {
            return String.valueOf(num).charAt(numWidth - 1) - '0';
        } else {
            return String.valueOf(num + 1).charAt(n % numWidth - 1) - '0';
        }
    }
}
