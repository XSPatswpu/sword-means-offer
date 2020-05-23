package list;

import java.util.ArrayList;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-21 15:28
 */
public class TestList0 {
    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
