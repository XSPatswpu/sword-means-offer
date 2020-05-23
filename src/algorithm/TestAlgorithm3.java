package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-22 13:39
 */
public class TestAlgorithm3 {
    /**
     * 一只青蛙一次可以跳上1级台阶，
     * 也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public static void main(String[] args) {
        System.out.println(new TestAlgorithm3().JumpFloorII(3));
    }

    /**
     * f(0) = 1
     * n = 1 f(n) = f(0) = 1
     * n = 2 f(n) = f(1) + f(0) = 2
     * n = 3 f(n) = f(2) + f(1) + f(0)= 4
     * n = 4 f(n) = 4
     */
    public int JumpFloorII(int target) {
        Integer[] memory = new Integer[target + 1];
        return getNumber1(target, memory);
    }

    private int getNumber0(int target, Integer[] memory) {
        if (memory[target] != null) {
            return memory[target];
        }
        if (target == 0 || target == 1) {
            return (memory[target] = 1);
        }
        int sum = 0;
        for (int i = 0; i < target; i++) {
            sum += getNumber0(i, memory);
        }
        return (memory[target] = sum);
    }

    private int getNumber1(int target, Integer[] memory) {
        if (memory[target] != null) {
            return memory[target];
        }
        if (target == 0 || target == 1) {
            return (memory[target] = 1);
        }
        return (memory[target] = 2 * getNumber1(target - 1, memory));
    }
}
