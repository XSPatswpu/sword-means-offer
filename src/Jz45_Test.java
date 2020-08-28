import java.util.HashSet;
import java.util.Set;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/28 16:56
 */
public class Jz45_Test {

    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] num = {0, 0, 1, 2, 6};

        Jz45_Test test = new Jz45_Test();
        System.out.println(test.isContinuous(num));
    }

    public boolean isContinuous(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                boolean add = set.add(numbers[i]);
                if (!add) {
                    return false;
                }
                if (count == 0) {
                    max = numbers[i];
                    min = numbers[i];
                } else {
                    if (numbers[i] > max) {
                        max = numbers[i];
                    } else if (numbers[i] < min) {
                        min = numbers[i];
                    }
                }
                count++;
            }
        }
        return max - min < 5;
    }
}
