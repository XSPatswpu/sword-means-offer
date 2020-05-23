package tree;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-26 15:25
 */
public class TreeTest1 {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public static void main(String[] args) {

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 注意找到真正重复的结构
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            result = doHasSubtree(root1.left, root2.left) && doHasSubtree(root1.right, root2.right);
        }
        // 重新判断root1的左右子树
        if (!result) {
            result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    /**
     * 基本树结构包含判断
     */
    private boolean doHasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return doHasSubtree(root1.left, root2.left) && doHasSubtree(root1.right, root2.right);
        }
        return false;
    }
}
