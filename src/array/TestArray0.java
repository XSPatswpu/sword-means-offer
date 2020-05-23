package array;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-20 17:36
 */
public class TestArray0 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static void main(String[] args) {
        int[][] arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        TestArray0 test = new TestArray0();
        System.out.println(test.find1(arrays, 3));
    }

    public boolean find0(int[][] array, int target) {
        if (array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找
     */
    public boolean find1(int[][] array, int target) {
        if (array.length == 0) {
            return false;
        }
        // 确定一维数组
        for (int i = 0; i < array.length; i++) {
            // 确定二维数组
            if (array[i].length == 0) {
                return false;
            }
            int left = 0, right = array[i].length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target < array[i][mid]) {
                    right = mid - 1;
                } else if (target > array[i][mid]) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}











