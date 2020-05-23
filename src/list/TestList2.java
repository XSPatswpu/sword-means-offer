package list;

import java.util.Stack;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-24 12:14
 */
public class TestList2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public static void main(String[] args) {
        TestList2 test = new TestList2();
        ListNode firstNode = test.new ListNode(0);
        ListNode temp = firstNode;
        for (int i = 0; i < 5; i++) {
            temp = temp.next = test.new ListNode(i);
        }

        firstNode = test.ReverseList2(firstNode);
        do {
            System.out.println(firstNode.val);
        } while ((firstNode = firstNode.next) != null);

    }

    /**
     * 栈实现
     */
    public ListNode ReverseList0(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> contain = new Stack<>();
        ListNode node = head;
        do {
            contain.push(node);
        } while ((node = node.next) != null);

        ListNode firstNode = contain.pop();
        ListNode temp = firstNode;
        while (!contain.empty()) {
            temp = temp.next = contain.pop();
        }
        temp.next = null;
        return firstNode;
    }

    /**
     * 移除头节点
     *
     * 注意：
     * 1、操作指针之前要先把原指针指向的值进行备份
     * 2、left = right, 引用类型赋值的过程，可以理解为给left进行赋值或给right进行备份
     *
     */
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 左指针
        ListNode left = head;
        // 右指针
        ListNode right = head.next;
        left.next = null;
        do {
            ListNode temp = right;
            right = right.next;
            temp.next = left;
            left = temp;
        } while (right != null);
        return left;
    }

    public ListNode ReverseList2(ListNode head) {
        // 左指针
        ListNode left = null;
        // 右指针
        ListNode right = null;
        while (head != null){
            right = head;
            head = head.next;
            right.next = left;
            left = right;
        }
        return left;
    }

}
