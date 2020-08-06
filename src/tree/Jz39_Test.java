package tree;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/6 16:56
 */
public class Jz39_Test {

    class TreeNode {
        int val;
        Jz39_Test.TreeNode left;
        Jz39_Test.TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * @param args

     *           8
     *         /  \
     *        6   10
     *       / \  / \
     *      5  7 9  11
     *     / \
     *    12 14
     *
     */
    public static void main(String[] args) {
        Jz39_Test test = new Jz39_Test();
        Jz39_Test.TreeNode node1 = test.new TreeNode(8);
        Jz39_Test.TreeNode node2 = test.new TreeNode(6);
        Jz39_Test.TreeNode node3 = test.new TreeNode(10);
        Jz39_Test.TreeNode node4 = test.new TreeNode(5);
        Jz39_Test.TreeNode node5 = test.new TreeNode(7);
        Jz39_Test.TreeNode node6 = test.new TreeNode(9);
        Jz39_Test.TreeNode node7 = test.new TreeNode(11);
        Jz39_Test.TreeNode node8 = test.new TreeNode(12);
        Jz39_Test.TreeNode node9 = test.new TreeNode(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        System.out.println(IsBalanced_Solution(node1));

    }

    public static boolean IsBalanced_Solution(TreeNode tree) {

        // 递归终止
        if (tree == null) {
            return true;
        }

        if (IsBalanced_Solution(tree.left) && IsBalanced_Solution(tree.right)) {
            return Math.abs(treeMaxDeep(tree.left) - treeMaxDeep(tree.right)) < 2;
        }

        return false;

    }

    public static int treeMaxDeep(TreeNode treeRoot) {
        // 递归终止条件
        if (treeRoot == null) {
            return 0;
        }

        if (treeRoot.left == null && treeRoot.right == null) {
            return 1;
        }

        if (treeRoot.left == null) {
            return treeMaxDeep(treeRoot.right) + 1;
        }

        if (treeRoot.right == null) {
            return treeMaxDeep(treeRoot.left) + 1;
        }

        return Math.max(treeMaxDeep(treeRoot.left), treeMaxDeep(treeRoot.right)) + 1;
    }


}
