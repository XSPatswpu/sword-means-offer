package list;

import java.util.HashMap;

/**
 * @author: xiangshaopeng
 * @date: 2019-11-24 16:22
 */
public class TestList4 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 输入一个复杂链表
     * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。
     */
    public static void main(String[] args) {

    }

    /**
     * 1. 克隆主链表
     * 2. 存储主链表和复制链表的对应关系,HashMap
     * 3. 克隆特殊指针
     * @param pHead
     * @return
     */
    public RandomListNode Clone0(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode tempClone = cloneHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(pHead, tempClone);
        RandomListNode originHead = pHead;
        while ((pHead = pHead.next) != null) {
            tempClone = tempClone.next = new RandomListNode(pHead.label);
            map.put(pHead, tempClone);
        }

        cloneHead = processRandomNode(originHead, cloneHead, map);

        return cloneHead;
    }

    private RandomListNode processRandomNode(RandomListNode originHead, RandomListNode cloneHead, HashMap<RandomListNode, RandomListNode> map) {
        RandomListNode tempCloneHead = cloneHead;
        while (originHead != null) {
            RandomListNode tempNode = originHead.random;
            tempCloneHead.random = tempNode == null ? null : map.get(tempNode);

            originHead = originHead.next;
            tempCloneHead = tempCloneHead.next;
        }
        return cloneHead;
    }


}
