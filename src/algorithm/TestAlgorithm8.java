package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2020/5/21 17:56
 */
public class TestAlgorithm8 {

    /**
     * 连续子数组的最大和
     * [1,-2,3,10,-4,7,2,-5]
     *
     * 1. 如果累计和 < 0，而下一个数 > 0，从下一个数重新开始
     * 2. 每次累加之后检查最大值是否要更新
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        // int[] testArray = {-2,-8,-1,-5,-9};
        int[] testArray = {1,-2,3,10,-4,7,2,-5};

        TestAlgorithm8 algorithm = new TestAlgorithm8();
        System.out.println(algorithm.maxSubArray(testArray));

    }

    public int maxSubArray(int[] originArray) {

        if (originArray == null || originArray.length == 0) {
            return -1;
        }

        int max, tempMax;
        max = tempMax = originArray[0];
        for (int i = 0; i < originArray.length; i++) {
            if (i > 0) {
                tempMax += originArray[i];
            }

            if (tempMax < originArray[i] && originArray[i] > max) {
                max = tempMax = originArray[i];
                continue;
            }

            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }



}
