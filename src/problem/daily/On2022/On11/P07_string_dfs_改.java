package problem.daily.On2022.On11;

import java.util.ArrayList;
import java.util.List;

public class P07_string_dfs_改 {

    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int L = 1; L < s.length(); L++) {
            List<String> lli = getPos(s.substring(0, L));
            if (lli.isEmpty()) {
                continue;
            }
            List<String> rli = getPos(s.substring(L));
            if (rli.isEmpty()) {
                continue;
            }
            for (String ls : lli) {
                for (String rs : rli) {
                    res.add("(" + ls + ", " + rs + ")");
                }
            }
        }
        return res;
    }

    // 将字符串分成左右两部分后，分别对两部分找小数点可能在的位置
    public List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if (s.charAt(0) != '0' || s.equals("0")) {
            pos.add(s); // 不加小数点
        }

        for (int p = 1; p < s.length(); p++) {
            if ((s.charAt(0) == '0' && p != 1) || (s.charAt(s.length() - 1) == '0')) {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }
}
