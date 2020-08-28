/**
 * @author: xiangshaopeng
 * @date: 2020/8/28 19:23
 */
public class Jz47_Test {
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public int Sum_Solution(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return Sum_Solution(n - 1) + n;
    }


}
