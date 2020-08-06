package tree;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/6 16:02
 */
public class Jz38_Test {

    class TreeNode {
        int val;
        Jz38_Test.TreeNode left;
        Jz38_Test.TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 二叉树最大深度
     *
     *           8
     *         /  \
     *        6   10
     *       / \  / \
     *      5  7 9  11
     *
     */
    public static void main(String[] args) {
        Jz38_Test test = new Jz38_Test();
        Jz38_Test.TreeNode node1 = test.new TreeNode(8);
        Jz38_Test.TreeNode node2 = test.new TreeNode(6);
        Jz38_Test.TreeNode node3 = test.new TreeNode(10);
        Jz38_Test.TreeNode node4 = test.new TreeNode(5);
        Jz38_Test.TreeNode node5 = test.new TreeNode(7);
        Jz38_Test.TreeNode node6 = test.new TreeNode(9);
        Jz38_Test.TreeNode node7 = test.new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        System.out.println(treeMaxDeep(node1));

    }

    public static int treeMaxDeep(TreeNode treeRoot) {
        // 递归终止条件
        if (treeRoot.left == null && treeRoot.right == null) {
            return 0;
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
