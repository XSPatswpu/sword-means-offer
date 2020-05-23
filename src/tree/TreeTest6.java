package tree;

/**
 * @author: xiangshaopeng
 * @date: 2019-12-24 13:45
 */
public class TreeTest6 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * 关键点：
     * 1. 每遍历到一个节点，则记录链表的最后一个节点lastNode，并建立lastNode与当前节点的指向关系
     * 2. 只有当当前节点的左孩子为null或者处理完左孩子节点回到上层节点，lastNode才与当前节点建立指向关系
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeTest6 test = new TreeTest6();
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

        TreeNode firstListNode = test.Convert(node1);
        while (firstListNode != null) {
            System.out.println(firstListNode.val);
            firstListNode = firstListNode.right;
        }
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode lastListNode;

        lastListNode = doConvert(pRootOfTree, null);

        while (lastListNode != null) {
            if (lastListNode.left == null) {
                break;
            }
            lastListNode = lastListNode.left;
        }
        return lastListNode;
    }

    private TreeNode doConvert(TreeNode currentTreeNode, TreeNode lastListNode) {
        if (currentTreeNode.left != null) {
            lastListNode = doConvert(currentTreeNode.left, lastListNode);
        }

        currentTreeNode.left = lastListNode;
        if (lastListNode != null) {
            lastListNode.right = currentTreeNode;
        }
        lastListNode = currentTreeNode;

        if (currentTreeNode.right != null) {
            lastListNode = doConvert(currentTreeNode.right, lastListNode);
        }
        return lastListNode;
    }
}
