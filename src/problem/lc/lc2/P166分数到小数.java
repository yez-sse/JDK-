package problem.lc.lc2;

import java.util.HashMap;
import java.util.Map;

public class P166分数到小数 {

    //思路上还得是宫水三叶
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }
        StringBuilder sb = new StringBuilder();
        //正负号处理
        if (numerator * denominator < 0) {
            sb.append("-");
        }
        numerator = Math.abs(numerator);    //这个地方应该用一个long来代替这两个数字的
        denominator = Math.abs(denominator);
        //整数部分
        sb.append(numerator / denominator + ".");    //有个问题就是对于那些很小的小数，int范围是不够的
        //小数部分
        numerator = numerator % denominator;
        Map<Integer, Integer> map = new HashMap<>();
        while (numerator != 0) {
            map.put(numerator, sb.length());
            numerator *= 10;
            sb.append(numerator / denominator);
            numerator %= denominator;
            if (map.containsKey(numerator)) {
                int u = map.get(numerator);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }

        return sb.toString();
    }

    //自己对这种模拟题是真的不行啊
//    public String fractionToDecimal(int numerator, int denominator) {
//        double res = numerator * 1.0 / (denominator * 1.0);
//        StringBuilder sb = new StringBuilder();
//        if (Double.isFinite(numerator * 1.0 / (denominator * 1.0))) {
//            return String.valueOf(res);
//        } else {
//            String resStr = String.valueOf(res);
//            String resStr1 = resStr.split(".")[0];
//            String resStr2 = resStr.split(".")[1];
//            if (resStr2.charAt(0) == resStr2.charAt(1) &&
//                    resStr2.charAt(1) == resStr2.charAt(2) && resStr2.charAt(2) == resStr2.charAt(3)) {
//                return
//            }
//        }
//    }
}
