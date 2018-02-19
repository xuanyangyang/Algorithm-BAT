package ch05;

/**
 * 5.5
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if (head == null)
            return head;

        ListNode leftHead = null;
        ListNode leftNode = null;
        ListNode rightHead = null;
        ListNode rightNode = null;
        ListNode node = head;

        while (node != null) {
            if (node.val <= val) {
                if (leftHead == null) {
                    leftHead = node;
                    leftNode = leftHead;
                } else {
                    leftNode.next = node;
                    leftNode = node;
                }
            } else {
                if (rightHead == null) {
                    rightHead = node;
                    rightNode = rightHead;
                } else {
                    rightNode.next = node;
                    rightNode = node;
                }
            }
            node = node.next;
        }

        // 如果没有小于等于阈值，则只有大于阀值的部分，令头节点等于右边起始节点
        if (leftHead == null)
            head = rightHead;
        else {  // 否则就是要连接左右部分
            head = leftHead;
            leftNode.next = rightHead;
        }

        if (rightHead != null)  // 如果有右部分，则把尾节点的next置空
            rightNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(71);
        ListNode preNode = head;
        ListNode node = new ListNode(7);
        preNode.next = node;
        preNode = node;
//        node = new ListNode(2);
//        preNode.next = node;
//        preNode = node;

        Divide divide = new Divide();
        head = divide.listDivide(head, 71);
        node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
