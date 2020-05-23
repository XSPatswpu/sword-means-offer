package tree;

import java.util.Arrays;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-21 15:42
 */
public class TreeTest0 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        new TreeTest0().reConstructBinaryTree(pre, in);

    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，
     * 请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回。
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // i 表示左边树数量
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                return root;
            }
        }
        return root;
    }
}
