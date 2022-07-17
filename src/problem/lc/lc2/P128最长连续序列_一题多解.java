package problem.lc.lc2;

import problem.one.UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P128最长连续序列_一题多解 {

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (Map.Entry entry : map.entrySet()) {
//                //HashMap的键有序吗？什么时候有序？
//            }
//        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            int len = left + 1 + right;
            map.put(nums[i], 1);  //这里还不能把这句话的位置放到最下面或者别的地方，还容易出问题
            map.put(nums[i] - left, len);   //只要两头是最新最长的就可以了
            map.put(nums[i] + right, len);
            res = Math.max(len, res);
        }
        return res;
    }

    //直接用Set来去重，这个比较好想一些
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {   //保证下面的while不会重复执行
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            res = Math.max(res, cur - num + 1);
        }
        return res;
    }

    //用并查集，所有在一个连续区间内的元素都会在一个连通分量中
    public int longestConsecutive3(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            if (uf.find(num + 1) != null) {
                uf.union(num, num + 1);
            }
        }

        int res = 0;
        for (int num : nums) {
            int right = uf.find(num);
            res = Math.max(res, right - num + 1);
        }
        return res;
    }
}

