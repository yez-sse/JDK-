package acwing.string;

import java.util.*;

public class P776字符串移位包含 {

    private static String s1;
    private static String s2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        s1 = ss[0];
        s2 = ss[1];
        if (ss[0].length() < ss[1].length()) {
            s1 = ss[1];
            s2 = ss[0];
        }
        if (check(s1, s2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean check(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            s1 = s1.substring(1) + s1.charAt(0);
            if (s1.contains(s2)) {
                return true;
            }
        }
        return false;
    }
}
