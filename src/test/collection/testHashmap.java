package test.collection;

import java.util.HashMap;
import java.util.Map;

public class testHashmap {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("K1", 1.0);
        map.put("K2", 2.0);
        map.put("k3", 3.0);
        map.put("K4", 4.0);
        map.put("K5", 2.0);
        map.put("k6", 3.0);
        map.put("K7", 4.0);
        map.put("K8", 2.0);
        map.put("k9", 3.0);
        map.put("K10", 4.0);
        map.put("K11", 4.0);
        map.put("K12", 4.0);
        map.put("K13", 4.0);


        Map<String, Integer> map1 = new HashMap<String, Integer>(){
            {
                put("abc", 2); put("def", 3); put("ghi", 4);
                put("jkl", 5); put("mno", 6); put("tuv", 8);
                put("pqrs", 7); put("wxyz", 9);
            }
        };

    }
}
