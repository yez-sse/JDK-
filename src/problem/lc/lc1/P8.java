package problem.lc.lc1;

public class P8 {
    public static void main(String[] args) {

    }

    public static int myStoI(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        // 丢弃无用的前导空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }

        // 处理符号的问题
        int sign = 1;
        if (chars[index] == '+') {
            index++;
        } else if (chars[index] == '-') {
            sign = -1;
            index++;
        }

        // 处理数字部分
        int res = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        while (index < len && chars[index] >= '0' && chars[index] <= '9') {
            if (res > max / 10 || (res == max / 10 && chars[index] - '0' > max % 10)) {
                return max;
            }
            if (res < min / 10 || (res == min / 10 && chars[index] - '0' > -(max % 10))) {
                return min;
            }
            res = res * 10 + sign * (chars[index] - '0');
            index++;
        }

        return res;
    }
}
