package problem.lc.lc2;

public class P125验证回文串 {

    //在原字符串的基础上，使用双指针
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //我写的，普通思路吧
    public boolean isPalindrome(String s) {
        String temp = flatten(s);
        // System.out.println(temp);
        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public String flatten(String s) {
        StringBuilder builder = new StringBuilder();
        char[] ss = s.toLowerCase().toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (Character.isLetter(ss[i]) || Character.isDigit(ss[i])) {
                builder.append(ss[i]);
            }
        }
        return builder.toString();
    }
}
