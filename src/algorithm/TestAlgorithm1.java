package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-21 20:13
 */
public class TestAlgorithm1 {
    public static void main(String[] args) {
        System.out.println(new TestAlgorithm1().Fibonacci1(1));
    }
    /**
     * 大家都知道斐波那契数列，
     * 现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */
    public int Fibonacci0(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci0(n - 1) + Fibonacci0(n - 2);
    }

    /**
     * 备忘录
     */
    public int Fibonacci1(int n) {
        Integer[] memory = new Integer[n + 1];
        return getMemory(n, memory);
    }

    private int getMemory(int n, Integer[] memory) {
        if (n == 0) {
            memory[n] = 0;
            return memory[n];
        }
        if (n == 1 || n == 2) {
            memory[n] = 1;
            return memory[n];
        }
        if (memory[n] == null) {
            memory[n] = getMemory(n - 2, memory) + getMemory(n - 1, memory);
        }
        return memory[n];
    }
}
