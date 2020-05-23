package list;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-24 16:22
 */
public class TestList3 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public static void main(String[] args) {
        TestList3 test = new TestList3();
        ListNode n1 = test.new ListNode(1);
        ListNode n2 = test.new ListNode(3);
        ListNode n3 = test.new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = test.new ListNode(5);
        ListNode m2 = test.new ListNode(5);
        ListNode m3 = test.new ListNode(5);
        m1.next = m2;
        m2.next = m3;

        ListNode list = test.Merge1(n1, m1);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
     }

    /**
     * 递归实现
     * 注意：递归必须要有终止条件
     */
    public ListNode Merge0(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = Merge0(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge0(list2.next, list1);
            return list2;
        }
    }

    /**
     * 非递归实现
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 由于firstNode需要返回，故先求之
        ListNode firstNode;
        if (list1.val <= list2.val) {
            firstNode = list1;
            list1 = list1.next;
        } else {
            firstNode = list2;
            list2 = list2.next;
        }

        ListNode current = firstNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current = current.next = list1;
                list1 = list1.next;

            } else {
                current = current.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        }
        if (list2 == null) {
            current.next = list1;
        }
        return firstNode;
    }
}
