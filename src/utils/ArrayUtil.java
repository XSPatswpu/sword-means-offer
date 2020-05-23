package utils;

/**
 * @author: xiangshaopeng
 * @date: 2020/5/21 21:27
 */
public class ArrayUtil {
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
    }
}
