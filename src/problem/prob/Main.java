package problem.prob;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        double res = stringToDouble(str);
        System.out.print(res);
    }

    public static double stringToDouble(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        double res = 0;
        int index = 0;
        while (index < len && chars[index] != '.') {
            res = res * 10 + chars[index] - '0';
            index++;
        }
        index++;
        double times = 1.0;
        while (index < len) {
            res += (chars[index] - '0') * 1.0 * Math.pow(0.1, times);
            index++;
            times += 1.0;
        }
        return res;
    }
}





































