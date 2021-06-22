package test.string;

public class testString {
    public static void main(String[] args) {
        String str = new String();
        String s = "021Abc9Abc1";
        str = s;
        String s1 = s.substring(0, 3);
        str.lastIndexOf("Abc");
        s += str;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(str);
        sb.append(1.2);
        StringBuffer sbb = new StringBuffer();
        sbb.append(str);
        sbb.append(s);
        sbb.toString();
    }
}
