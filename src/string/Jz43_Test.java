package string;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/10 16:16
 */
public class Jz43_Test {

    /**
     * 左旋转字符串
     * @param args
     */
    public static void main(String[] args) {

    }


    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }

        return str.substring(n) + str.substring(0, n);

    }


}
