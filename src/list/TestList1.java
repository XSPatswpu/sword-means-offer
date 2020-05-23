package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-23 16:39
 */
public class TestList1 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public static void main(String[] args) {
    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        /**
         * easy
         */
        public ListNode FindKthToTail0(ListNode head,int k) {
            if (head == null) {
                return null;
            }
            List<ListNode> list = new ArrayList<>();
            list.add(head);
            ListNode node = head;
            while ((node = node.next) != null) {
                list.add(node);
            }
            if (list.size() - k < 0 || k < 1) {
                return null;
            }
            return list.get(list.size() - k);
        }

        /**
         * 双指针
         */
        public ListNode FindKthToTail1(ListNode head,int k) {
            if (head == null) {
                return null;
            }
            ListNode left, right;
            left = right = head;
            for (int i = 0; i < k - 1; i++) {
                if ((right = right.next) == null) {
                    return null;
                }
            }
            while ((right = right.next) != null) {
                left = left.next;
            }
            return left;
        }

    }




}
