/**
 * @author: xiangshaopeng
 * @date: 2020/9/2 17:56
 */
public class Jz67_Test {

    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * @param args
     */
    public static void main(String[] args) {

        Jz67_Test test = new Jz67_Test();
        int i = test.cutRope(10);
        System.out.println(i);

    }

    public int cutRope(int target) {
        if (target == 4) {
            return 4;
        }
        if (target == 3) {
            return 2;
        }
        if (target == 2) {
            return 1;
        }
        int[] arr = new int[target + 1];
        return doCutRope(target, arr);
    }

    public int doCutRope(int target, int[] arr) {
        int maxMulti = Integer.MIN_VALUE;
        // 递归终止条件
        if (target <= 4) {
            return target;
        }

        if (arr[target] != 0) {
            return arr[target];
        }

        for (int i = 1; i < target; i++) {
            int temp = doCutRope(target - i, arr);
            arr[target - i] = temp;

            if (i * temp > maxMulti) {
                maxMulti = i * temp;
            }
        }
        return maxMulti;
    }



}
