package ch05;

/**
 * 5.14
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 */
public class ChkIntersection {
    /*
    如果相交有2种情况
    1.在入环前相交，则入环点一致
    2.在环里相交，则绕环转一圈寻找一致点
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode node1 = find(head1);
        ListNode node2 = find(head2);

        if(node1 == node2)
            return true;

        ListNode cur = node1.next;// 保存环1的入口下一个点，再次到达这个点则已经转了一圈

        while (node1 != cur){
            if(cur == node2)
                return true;
            cur = cur.next;
        }

        return false;
    }

    public ListNode find(ListNode head) { // 找到入环点
        ListNode fast = head;
        ListNode normal = head;

        while (fast.next != null && fast.next.next != null) {
            normal = normal.next;
            fast = fast.next.next;
            if (fast == normal)
                break;
        }

        fast = head;

        while (fast != normal) {
            fast = fast.next;
            normal = normal.next;
        }

        return fast;
    }
}
