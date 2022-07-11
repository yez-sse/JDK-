package problem.lc.lc2;

import problem.prob.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P95不同的二叉搜索树II_递归_自底向上 {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    public List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            //每个i作为root节点，把左右拼起来，这样每个i由下往上都加到树上去了
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
