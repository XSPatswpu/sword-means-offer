package algorithm;

import java.util.ArrayList;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-27 14:04
 */
public class TestAlgorithm7 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     */
    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        int[] array3 = {5, 6};
        int[] array4 = {7, 8};
        int[] array5 = {9, 10};
        //[1,2,4,6,8,10,9,7,5,3]
        int[][] array = {array1, array2, array3, array4, array5};
        ArrayList<Integer> result = new TestAlgorithm7().printMatrix(array);
        for (Integer integer : result) {
            System.out.print(integer + ",");
        }

    }

    /**
     * 分两步
     * 1. 外层循环
     * 2. 打印边框
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int yLength = matrix.length, xLength = matrix[0].length;
        for (int x = 0, y = 0; x * 2 < xLength && y * 2 < yLength; x++, y++) {
            printBound(matrix, result, xLength, yLength, x, y);
        }
        return result;
    }

    private void printBound(int[][] matrix, ArrayList<Integer> result, int xLength, int yLength, int startX, int startY) {
        /*
        1. 确定x,y移动之后的坐标
        2. 依次判是否需要打印上、右、下、左
         */

        int endX = xLength - 1 - startX;
        int endY = yLength - 1 - startY;

        // 打印上边界
        for (int i = startX; i <= endX; i++) {
            result.add(matrix[startY][i]);
        }

        // 打印右边界
        if (endY - startY > 0) {
            for (int i = startY + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }

        // 打印下边界条件：x、y偏移量都大于0
        if (endX - startX > 0 && endY - startY > 0) {
            for (int i = endX - 1; i >= startX ; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 打印左边界条件
        if (endX - startX > 0 && endY - startY > 1) {
            for (int i = endY - 1; i > startY ; i--) {
                result.add(matrix[i][startX]);
            }
        }
    }
}
