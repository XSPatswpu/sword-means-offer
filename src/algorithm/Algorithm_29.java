package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_29 {


    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param args
     */
    public static void main(String[] args) {

//        int[] array = {-1,2,3,1,9,6};
        int[] array = {4,5,1,6,2,7,3,8};

        Algorithm_29 test_29 = new Algorithm_29();

        List<Integer> latestNumbers = test_29.findLatestNumbers(array, 4);

        System.out.println(latestNumbers);

    }

    /**
     * 方式一：
     * 快速排序
     * @param array
     * @return
     */
    public List<Integer> findLatestNumbers(int[] array, int target) {
        List<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        return doFindLatestNumbers(array, 0, array.length - 1, target - 1);

    }

    private List<Integer> doFindLatestNumbers(int[] array, int start, int end, int target) {

        int index = getIndex(array, start, end);
        if (index > target) {
            return doFindLatestNumbers(array, start, index - 1, target);
        } else if (index < target) {
            return doFindLatestNumbers(array, index + 1, end, target);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < index + 1; i++) {
            result.add(array[i]);
        }
        return result;

    }

    private int getIndex(int[] array, int start, int end) {
        if (start >= end) {
            return start;
        }
        // 取最后元素为基准点
        int index = array[end];

        int i = start;

        for (int j = start; j < end; j++) {
            if (array[j] < index) {
                swapInArray(array, i, j);
                i++;
            }
        }

        swapInArray(array, end, i);
        return i;
    }

    private void swapInArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
