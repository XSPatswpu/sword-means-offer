package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: xiangshaopeng
 * @date: 2020/8/7 15:42
 */
public class Jz42_Test {

    /**
     * 和为S的连续正数序列
     * @param args
     */
    public static void main(String[] args) {
        Jz42_Test test = new Jz42_Test();

        System.out.println(test.FindContinuousSequence(4));

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (sum <= 1) {
            return res;
        }

        LinkedList<Integer> list = new LinkedList<>();
        int listSum = 0;
        int cur = 0;
        while (cur <= (sum / 2 + 1)) {
            if (listSum == sum) {
                res.add(new ArrayList<>(list));
                cur++;
                listSum += cur;
                list.add(cur);
            } else if (listSum < sum) {
                cur++;
                listSum += cur;
                list.add(cur);
            } else {
                Integer head = list.removeFirst();
                listSum -= head;
            }
        }
        return res;
    }

}
