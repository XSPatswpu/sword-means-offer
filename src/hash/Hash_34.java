package hash;

import java.util.HashMap;

public class Hash_34 {

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * @param args
     */
    public static void main(String[] args) {
        Hash_34 hash_34 = new Hash_34();
        System.out.println(hash_34.firstNotRepeatingChar("dsggsfdjhgbbhfjca"));

    }

    public int firstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Integer count = hash.get(str.charAt(i));
            if (count == null) {
                hash.put(str.charAt(i), 1);
            } else {
                hash.put(str.charAt(i), ++count);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (hash.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
