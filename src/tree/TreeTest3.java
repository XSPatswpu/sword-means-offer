package tree;

import list.TestList3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-28 14:20
 */
public class TreeTest3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * 用例:
     * {10,6,14,4,8,12,16}
     *
     * 对应输出应该为:
     *
     * [10,6,14,4,8,12,16]
     *
     *
     *           8
     *         /  \
     *        6   10
     *       / \  / \
     *      5  7 9  11
     *
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        printTree(queue, result);
        return result;
    }

    /**
     * 从队列弹出节点，然后把节点的左右儿子树放入队列
     */
    private void printTree(LinkedList<TreeNode> queue, ArrayList<Integer> result) {
        if (queue.isEmpty()) {
            return;
        }
        TreeNode tempRoot = queue.poll();
        result.add(tempRoot.val);
        if (tempRoot.left != null) {
            queue.offer(tempRoot.left);
        }

        if (tempRoot.right != null) {
            queue.offer(tempRoot.right);
        }
        printTree(queue, result);
    }

    /**
     *
     *           8
     *         /  \
     *        6   10
     *       / \  / \
     *      5  7 9  11
     *
     */
    public static void main(String[] args) {
        TreeTest3 test = new TreeTest3();
        TreeNode node1 = test.new TreeNode(8);
        TreeNode node2 = test.new TreeNode(6);
        TreeNode node3 = test.new TreeNode(10);
        TreeNode node4 = test.new TreeNode(5);
        TreeNode node5 = test.new TreeNode(7);
        TreeNode node6 = test.new TreeNode(9);
        TreeNode node7 = test.new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ArrayList<Integer> list = test.PrintFromTopToBottom(node1);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }

    }
}
