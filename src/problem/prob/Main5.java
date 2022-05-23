package problem.prob;

public class Main5 {
    public static String BigNumberSub(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        int length1 = cs1.length;
        int length2 = cs2.length;
        int i = length1 - 1, j = length2 - 1, c = 0;

        for (; j >= 0; i--, j--) {
            if (cs1[i] >= cs2[j]) {
                ans.append((char) ('0' + cs1[i] - cs2[j] - c));
                c = 0;
            } else {
                c = 1;
                ans.append((char) ('0' + 10 + cs1[i] - cs2[j]));
            }
        }
        while (i-- > 0) {
            ans.append((char) ('0' + cs1[i] - c));
            c = 0;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "2345";
        String s2 = "1234";
        System.out.println(BigNumberSub(s1, s2));
    }
}
