package problem.lc.lc2;

public class P168Excel表列名称 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; //因为是
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }


    public int titleToNumber(String columnTitle) {
        int res = 0;
        int temp = 1;
        char[] cs = columnTitle.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            res = res + (cs[i] - 'A' + 1) * temp;
            temp *= 26;
        }
        return res;
    }
}
