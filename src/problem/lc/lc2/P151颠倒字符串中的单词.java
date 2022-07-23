package problem.lc.lc2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P151颠倒字符串中的单词 {

    public String reverseWords2(String s) {
//        s.trim();   //去掉头部和尾部的空格
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+")); //常用的正则表达式需要知道啊
        String[] strs = s.split("\\s+");
        Collections.reverse(wordList);
//        Arrays.reverse(strs);注释是因为Arrays没有这个方法
        System.out.println(String.join(" ", strs)); //这个倒是有的，但是不能reverse啊
        return String.join(" ", wordList);

    }


    //这么写有问题啊，split方法只能去掉头部的多余的空格，中间和尾部的去不掉
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
