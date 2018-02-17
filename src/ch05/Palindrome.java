package ch05;

/**
 * 5.9
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return true;

        ListNode leftNode = head;
        ListNode rightNode = head;
        while (rightNode.next != null && rightNode.next.next != null) {// 找到中间节点
            leftNode = leftNode.next; // 中间节点
            rightNode = rightNode.next.next;
        }

        ListNode node = reserve(leftNode.next); // 反转右边部分，并获得原链表最后一个节点即反转后的第一个节点

        rightNode = node;
        leftNode = head;
        boolean result = true;
        while (rightNode != null) {
            if (leftNode.val != rightNode.val) {
                result = false;
                break;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        reserve(node); // 还原右边部分

        return result;
    }

    public ListNode reserve(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 3, 2, 1};
        ListNode head = ListNode.makeList(data);
        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.isPalindrome(head);
        System.out.println(result);
    }

}
