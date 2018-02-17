package ch05;

/**
 * 5.11
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class Solution {
    public RandomListNode Clone(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode cur = head;

        while (cur != null) { // 在链表每个元素后面添加一个克隆元素
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        RandomListNode newNode;
        while (cur != null) { // 给每个克隆元素设置随机指针
            newNode = cur.next;
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode newHead = cur.next;
        RandomListNode next;

        while (cur != null) { // 分割出克隆链表，还原原链表
            next = cur.next.next;
            newNode = cur.next;
            newNode.next = next == null ? null : next.next;
            cur.next = next;
            cur = next;
        }

        return newHead;
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 3, 5, -1, 2, -1};
        RandomListNode head1 = RandomListNode.makeList(data);
        Solution solution = new Solution();
        RandomListNode head2 = solution.Clone(head1);
        RandomListNode node = head1;
        while (node != null) {
            System.out.print(node.label + " ");
            node = node.next;
        }
        System.out.println();
        node = head2;
        while (node != null) {
            System.out.print(node.label + " ");
            node = node.next;
        }
    }
}
