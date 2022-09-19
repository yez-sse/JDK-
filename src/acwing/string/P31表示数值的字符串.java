package acwing.string;

import java.util.*;

public class P31表示数值的字符串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String s = in.nextLine();
            if (isNumber(s)) {
                System.out.println("ture");
            } else {
                System.out.println("false");
            }
        }
    }

    public static boolean isNumber(String s) {
        s += "$";
        boolean isNum = false;
        int idx = 0;

        while (s.charAt(idx) == ' ') {
            idx++;
        }

        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
            idx++;
        }

        while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            idx++;
            isNum = true;   //这里要体会了，后续没问题能构成合法数字的话，这里就可以先变true，后续不能这么认为了就改成false
        }

        if (s.charAt(idx) == '.') {
            idx++;
        }

        while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            idx++;
            isNum = true;
        }

        if (isNum && (s.charAt(idx) == 'e' || s.charAt(idx) == 'E')) {
            idx++;
            isNum = false;  //有了e的话，就不能确定了，得改回false

            if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
                idx++;
            }

            while (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                idx++;
                isNum = true;
            }
        }

        //最后这句话简直核心啊
        return s.charAt(idx) == '$' && isNum;
    }
}
