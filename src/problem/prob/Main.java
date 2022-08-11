package problem.prob;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, HashSet<String>> m = new HashMap<>();
        while (n-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            if (ss[0].equals("1")) {
                String s2 = in.nextLine();
                String[] s2s = s2.split(" ");
                HashSet<String> set = new HashSet<>();
                for (int i = 0; i < s2s.length; i++) {
                    set.add(s2s[i]);
                }
                m.put(ss[1], set);
            } else {
                if (!m.keySet().contains(ss[1])) {
                    System.out.println("error");
                } else {
                    int res = 0;
                    HashSet<String> temp = new HashSet<>();
                    for (String key : m.get(ss[1])) {
                        temp.add(key);
                    }
                    for (String key : m.get(ss[1])) {
                        for (String key2 : m.keySet()) {
                            if (!key2.equals(ss[1])) {
                                if (m.get(key2).contains(key)) {
                                    for (String key3 : m.get(key2)) {
                                        if (!temp.contains(key3)) {
                                            temp.add(key3);
                                            res++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println(res);
                }
            }
        }
    }

    

}





































