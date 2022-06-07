package problem.lc.lc1;

import java.util.*;

public class P49字符串字母异位词 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
//            if (m.containsKey(chars.toString())) {
            if (m.containsKey(String.valueOf(chars))) {
//                m.get(chars.toString()).add(strs[i]);
                m.get(String.valueOf(chars)).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
//                m.put(chars.toString(), temp);
                m.put(String.valueOf(chars), temp);
            }
        }
        for (List<String> value : m.values()) {
            res.add(value);
        }

        return res;
    }
}
