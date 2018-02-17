package ch05;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public static RandomListNode makeList(int[] arr) {
        RandomListNode head = new RandomListNode(arr[0]);
        RandomListNode pre = head;
        RandomListNode node;
        for (int i = 1; i < arr.length; i++) {
            node = new RandomListNode(arr[i]);
            pre.next = node;
            pre = node;
        }

        return head;
    }
}
