package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-22 14:51
 */
public class TestAlgorithm4 {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * n = 1 f(1) = 1
     * n = 2 f(2) = f(1) + 1
     * n = 3 f(3) = f(2) + f(1)
     * n = 4 f(4) = f(3) + f(2)
     *
     */
    public static void main(String[] args) {
        System.out.println(new TestAlgorithm4().RectCover(4));
    }

    public int RectCover(int target) {
        Integer[] memory = new Integer[target + 1];
        return getNumber(target, memory);
    }

    private int getNumber(int target, Integer[] memory) {
        if (memory[target] != null) {
            return memory[target];
        }
        if (target == 0) {
            return (memory[target] = 0);
        }
        if (target == 1) {
            return (memory[target] = 1);
        }
        if (target == 2) {
            return (memory[target] = 2);
        }
        return (memory[target] = getNumber(target - 1, memory) + getNumber(target - 2, memory));
    }


}
