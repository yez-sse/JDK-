package problem.lc.lc2;

import java.util.*;

public class P187重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>(s.length() - 10);
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String tempStr = s.substring(i, i + 10);
            int tempNum = map.getOrDefault(s.substring(i, i + 10), 0) + 1;
            map.put(tempStr, tempNum);
            if (tempNum > 1) {
                set.add(tempStr);
            }
        }
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            res.add((String)iterator.next());
        }
        return res;
    }
}
