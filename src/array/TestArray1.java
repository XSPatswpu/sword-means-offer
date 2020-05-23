package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-23 15:23
 */
public class TestArray1 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public static void main(String[] args) {
        int[] array = {2,8,6,1,7,3,4,10};
        new TestArray1().reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 暴力法
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                left.add(array[i]);
            } else {
                right.add(array[i]);
            }
        }
        left.addAll(right);
        for (int i = 0; i < array.length; i++) {
            array[i] = left.get(i);
        }
    }
}
