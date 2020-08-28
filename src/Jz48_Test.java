/**
 * @author: xiangshaopeng
 * @date: 2020/8/28 19:24
 */
public class Jz48_Test {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     *
     * @param args
     */
    public static void main(String[] args) {
        Jz48_Test test = new Jz48_Test();
        int add = test.Add(20, 99);
        System.out.println(add);
    }

    /**
     *          a : 1 0 1
     *          b : 0 0 1
     * 第一次:
     *    无进位和 : 1 0 0
     *      进位和 : 0 1 0
     * 第二次：（无进位和 + 进位和）
     *    无进位和 : 1 1 0
     *      进位和 : 0 0 0
     *
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {

        int big, small;

        do {
            small = num1 ^ num2;
            big = (num1 & num2) << 1;
            num1 = small;
            num2 = big;
        } while (small != 0 && big != 0);

        if (small == 0) {
            return big;
        }

        return small;
    }


}
