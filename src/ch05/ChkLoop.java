package ch05;

/**
 * 5.12
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        if (head == null)
            return -1;

        ListNode fast = head;
        ListNode normal = head;

        while (fast.next != null && fast.next.next != null) {
            normal = normal.next;
            fast = fast.next.next;
            if (fast == normal)
                break;
        }

        if(fast == normal){
            fast = head;
            while (true){
                if(fast == normal)
                    return fast.val;
                fast = fast.next;
                normal = normal.next;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.makeList(data);
        ChkLoop chkLoop = new ChkLoop();
        int result = chkLoop.chkLoop(head, -1);
        System.out.println(result);
    }
}
