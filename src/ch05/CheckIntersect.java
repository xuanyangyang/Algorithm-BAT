package ch05;

/**
 * 5.13
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 */
public class CheckIntersect {
    /*
    只要有公共结点，那么后面的链表就一定相同，因为结点只有一个指针
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        if (headA == null || headB == null)
            return false;

        int lenA = 0;
        int lenB = 0;

        ListNode nodeA = headA;
        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        if (lenA > lenB) {
            nodeA = headA;
            while (lenB == 0) {
                nodeA = nodeA.next;
                lenB--;
            }
            nodeB = headB;
        } else {
            nodeB = headB;
            while (lenA == 0) {
                nodeB = nodeB.next;
                lenA--;
            }
            nodeA = headA;
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB)
                return true;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return false;
    }

    /*
    如果相交则链表尾必定一致
     */
    public boolean chkIntersect2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return false;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA.next != null)
            nodeA = nodeA.next;
        while (nodeB.next != null)
            nodeB = nodeB.next;

        return nodeA == nodeB;
    }
}
