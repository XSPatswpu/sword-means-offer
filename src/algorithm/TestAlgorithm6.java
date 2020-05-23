package algorithm;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-23 14:51
 */
public class TestAlgorithm6 {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    public double Power(double base, int exponent) {
        double result = 1.0;
        int absExponent = Math.abs(exponent);
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }

}
