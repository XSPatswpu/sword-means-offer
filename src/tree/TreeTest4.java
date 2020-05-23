package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-28 14:20
 */
public class TreeTest4 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * 二叉搜索树的基本特性：左孩子 < 根 < 右孩子
     *
     *           8
     *         /  \
     *        6   10
     *       / \  / \
     *      5  7 9  11
     *      后序遍历：{5,7,6,9,11,10,8}
     * 根 左 右
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        // 根
        int root = sequence[sequence.length - 1];

        boolean leftResult = true, rightResult = true;
        // 记录左子树
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        // 右子树
        int j = i;
        for (; j < sequence.length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 左子树存在，校验左子树
        if (i > 0) {
            leftResult = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        // 右子树存在，校验右子树
        if (i < sequence.length - 1 ) {
            rightResult = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
        }
        return leftResult && rightResult;
    }

    public static void main(String[] args) {
        TreeTest4 test = new TreeTest4();
        int[] array = {5,6,7,9,11,10,8};
        int[] array1 = {5,7,6,9,11,10,8};
        System.out.println(test.VerifySquenceOfBST(array1));
    }

}
