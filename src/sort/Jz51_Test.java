package sort;

import utils.ArrayUtil;

public class Jz51_Test {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * @param args
     */
    public static void main(String[] args) {
        Jz51_Test jz51 = new Jz51_Test();
//        int[] arr = {7,5};
        // ,235,2000000003,236,2000000007
        int[] arr = {233,2000000001,234,2000000006};
//        int[] arr = {7,5,5,6,6};


        System.out.println(jz51.inversePairs(arr));
        ArrayUtil.print(arr);
    }

    public int inversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int[] copy = new int[array.length];
        return doInversePairs(array, 0, array.length - 1, copy);
    }

    /**
     *
     * @param array
     * @param left
     * @param right
     * @param temp 合并数组时，临时存储合并之前的元素（因为原数组要排序）
     * @return
     */
    private int doInversePairs(int[] array, int left, int right, int[] temp) {
        if (right <= left) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        // 递归条件：当前逆序对 = 左边子数组逆序对 + 右边子数组逆序对 + 左右两边的逆序对
        // 合并数组时必须要排序，不然无法计算逆序对

        // 左边逆序对
        int leftCount = doInversePairs(array, left, mid, temp);

        // 右边逆序对
        int rightCount = doInversePairs(array, mid + 1, right, temp);

        // 左右数组合并并排序，计算出逆序对
        int mergeCount = mergeAndCountInverse(array, left, mid, right, temp);
        return leftCount + rightCount + mergeCount;
    }

    /**
     * left[left ... mid]
     * right[mid + 1 ... right]
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCountInverse(int[] array, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = i; k < right + 1; k++) {
            // 处理左右指针越界情况
            if (i > mid) {
                array[k] = temp[j];
                j++;
            } else if (j > right) {
                array[k] = temp[i];
                i++;
            }
            // 合并数组排序
            else if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }

}
