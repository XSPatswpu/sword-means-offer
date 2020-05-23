package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-22 10:18
 */
public class TestAlgorithm2 {
    public static void main(String[] args) {
        System.out.println(new TestAlgorithm2().JumpFloor1(1));
    }
    /**
     * 一只青蛙一次可以跳上1级台阶，
     * 也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * 1
     * 2
     * = 2 + 1 = 3
     * = 3 + 2 = 5
     */
    public int JumpFloor0(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor0(target - 1) + JumpFloor0(target - 2);
    }


    /**
     * 备忘录
     */
    public int JumpFloor1(int target) {
        Integer[] memory = new Integer[target + 1];
        return getMemory(target, memory);
    }

    private int getMemory(int target, Integer[] memory) {
        if (target == 0) {
            return (memory[target] = 0);
        }
        if (target == 1) {
            return (memory[target] = 1);
        }
        if (target == 2) {
            return (memory[target] = 2);
        }

        if (memory[target] == null) {
            return (memory[target] = getMemory(target - 1, memory) + getMemory(target - 2, memory));
        }
        return memory[target];
    }

}
