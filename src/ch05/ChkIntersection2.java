package ch05;

/**
 * 5.15
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 */
public class ChkIntersection2 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        if (head1 == null || head2 == null)
            return false;

        ListNode entryNode1 = find(head1);
        ListNode entryNode2 = find(head2);
        if (entryNode1 == null && entryNode2 == null) {  // 两个链表都是无环链表，若相交尾节点必定一致
            ListNode node1 = head1;
            ListNode node2 = head2;
            while (node1.next != null)
                node1 = node1.next;
            while (node2.next != null)
                node2 = node2.next;
            return node1 == node2;
        } else if (entryNode1 != null && entryNode2 != null) {  // 两个链表都是有环链表，转圈寻找相交点
            if (entryNode1 == entryNode2)
                return true;
            ListNode cur = entryNode1.next;
            while (cur != entryNode1) {
                if (cur == entryNode2)
                    return true;
                cur = cur.next;
            }
            return false;
        } else { // 一个有环一个无环，必定不相交
            return false;
        }
    }

    // 寻找入环点
    public ListNode find(ListNode head) {
        ListNode fast = head;
        ListNode normal = head;

        while (fast.next != null && fast.next.next != null) {
            normal = normal.next;
            fast = fast.next.next;
            if (normal == fast)
                break;
        }

        if (normal == fast) { // 有环
            fast = head;
            while (fast != normal) {
                fast = fast.next;
                normal = normal.next;
            }
            return fast;
        }

        return null;
    }
}
