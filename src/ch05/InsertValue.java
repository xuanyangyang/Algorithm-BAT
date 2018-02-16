package ch05;

/**
 * 5.2
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        ListNode head;

        if (A == null || A.length == 0) {
            head = new ListNode(val);
            head.next = head;
        } else {
            head = new ListNode(A[0]);
            ListNode pre = head;// 前一个节点
            ListNode cur;// 当前节点

            for (int next : nxt) {
                if (next == 0)
                    cur = head;
                else
                    cur = new ListNode(A[next]);
                pre.next = cur;
                pre = cur;
            }

            head = insertValue(head, val);
        }

        return head;
    }

    public ListNode insertValue(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != head) {
            if (pre.val <= val && val <= cur.val)
                break;
            pre = cur;
            cur = cur.next;
        }

        ListNode realHead;// 插入后的头节点

        // 没有在中间找到插入点，则要么val大于或者小于链表里所有数
        ListNode node = new ListNode(val);
        pre.next = node;
        node.next = cur;

        if (cur == head) {
            if (val < head.val)
                realHead = node;
            else
                realHead = head;
        } else {
            realHead = head;
        }

        return realHead;
    }

    public static void main(String[] args) {
        InsertValue insertValue = new InsertValue();
        int[] data = {4,8,9};
        int[] nxt = {1, 2, 0};
        ListNode head = insertValue.insert(data, nxt, 4);
        ListNode node = head;
        do {
            System.out.print(node.val + " ");
            node = node.next;
        } while (node != head);
    }
}
