package problem.lc.lc2;

import problem.prob.TreeNode;

import java.util.Arrays;

public class P105前中序构造二叉树 {


    //我写的，过了，但都只击败了5%，说明是个不行的答案。但递归的思想没用错。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) { //注意终止返回的条件
            return null;
        }
        int rootVal = preorder[0];
        int inRootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inRootIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, inRootIdx + 1), Arrays.copyOfRange(inorder, 0, inRootIdx));
        root.right = buildTree(Arrays.copyOfRange(preorder, inRootIdx + 1, preorder.length), Arrays.copyOfRange(inorder, inRootIdx + 1, inorder.length));
        return root;
    }

    //同上的方法中后序构造
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length <= 0) { //注意终止返回的条件
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        int inRootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inRootIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, inRootIdx), Arrays.copyOfRange(postorder, 0, inRootIdx));
        root.right = buildTree(Arrays.copyOfRange(inorder, inRootIdx + 1, inorder.length), Arrays.copyOfRange(postorder, inRootIdx, postorder.length - 1));
        return root;
    }
}
