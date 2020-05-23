package string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: xiangshaopeng
 * @date: 2020-01-19 14:57
 */
public class TestString1 {

    public static void main(String[] args) {
        TestString1 test1 = new TestString1();
        System.out.println(test1.Permutation("abc"));
    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
        }
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            for (int j = i; j < chars.length; ++j) {
                if (i != j && chars[i] == chars[j]) {
                    continue;
                }
                swap(chars, i, j);
                PermutationHelper(chars, i + 1, list);
                swap(chars, j, i);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
