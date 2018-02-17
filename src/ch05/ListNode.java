package ch05;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode makeList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        ListNode node;
        for (int i = 1; i < arr.length; i++) {
            node = new ListNode(arr[i]);
            pre.next = node;
            pre = node;
        }

        return head;
    }
}
