package tree;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: xiangshaopeng
 * @date: 2019-12-04 20:30
 */
public class TreeTest5 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一颗二叉树的跟节点和一个整数，
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     *
     *          10
     *         /  \
     *        5   12
     *       / \
     *      4  7
     *
     */
    public static void main(String[] args) {
        TreeTest5 test = new TreeTest5();
        TreeNode node1 = test.new TreeNode(10);
        TreeNode node2 = test.new TreeNode(5);
        TreeNode node3 = test.new TreeNode(12);
        TreeNode node4 = test.new TreeNode(4);
        TreeNode node5 = test.new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        ArrayList<ArrayList<Integer>> list = test.FindPath(node1, 22);
        for (ArrayList<Integer> integers : list) {
            System.out.println(integers);
        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int currentSum = 0;
        doFindPath(root, target, currentSum, new MyStack(), result);
        return result;
    }

    private void doFindPath(TreeNode node, int target, int currentSum, MyStack path, ArrayList<ArrayList<Integer>> result) {
        // 储存路径
        path.push(node.val);
        currentSum += node.val;

        if (isLeaf(node) && currentSum == target) {
            addToList(path.getElements(), result);
        }

        // 当前节点有左孩子
        if (node.left != null) {
            doFindPath(node.left, target, currentSum, path, result);
        }

        // 当前节点有右孩子
        if (node.right != null) {
            doFindPath(node.right, target, currentSum, path, result);
        }

        path.pop();
    }

    private void addToList(int[] pathArray, ArrayList<ArrayList<Integer>> result) {
        if (pathArray == null) {
            return;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : pathArray) {
            temp.add(i);
        }
        result.add(temp);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    class MyStack{
        private int[] elementData = new int[10];

        private int elementCount;

        public int[] getElements() {
            return Arrays.copyOfRange(elementData,0, elementCount);
        }

        public void push(int node) {
            sureCapacity(elementCount);
            elementData[elementCount++] = node;
        }

        private void sureCapacity(int elementCount) {
            if (elementCount >= size()) {
                elementData = Arrays.copyOf(elementData, size() << 1);
            }
        }

        public int pop() {
            int popValue = elementData[elementCount - 1];
            elementCount--;
            isShrinkCapacity(elementCount);
            return popValue;
        }

        private void isShrinkCapacity(int elementCount) {
            if ((elementCount << 1) <= size()) {
                elementData = Arrays.copyOf(elementData, size() >> 1);
            }
        }

        public int top() {
            return elementData[elementCount - 1];
        }

        public boolean isEmpty() {
            return elementCount == 0;
        }

        /**
         * 栈结构外壳的大小
         */
        public int size() {
            return elementData.length;
        }
    }
}
