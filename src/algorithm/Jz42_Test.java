package algorithm;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/7 16:54
 */
public class Jz42_Test {

    /**
     * 和为S的两个数字
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Jz42_Test test = new Jz42_Test();
        System.out.println(test.FindNumbersWithSum(arr, 7));


    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        int minMulti = -1;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (set.contains(sum - array[i])) {
                int multi = array[i] * (sum - array[i]);

                // first
                if (minMulti < 0) {
                    minMulti = multi;
                    result = createList(array[i], sum - array[i]);
                    continue;
                }

                if (minMulti > multi) {
                    minMulti = multi;
                    result = createList(array[i], sum - array[i]);
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> createList(int... a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        return list;
    }
}
