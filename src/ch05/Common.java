package ch05;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.6
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        if (headA == null || headB == null)
            return null;

        List<Integer> resultList = new ArrayList<>();

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val == nodeB.val) {
                resultList.add(nodeA.val);
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            } else if (nodeA.val < nodeB.val)
                nodeA = nodeA.next;
            else
                nodeB = nodeB.next;
        }

        int resultSize = resultList.size();
        int[] result = new int[resultSize];

        for (int i = 0; i < resultSize; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Common common = new Common();
        int[] arrA = {0, 3, 9, 11, 15, 21, 27, 28, 31};
        int[] arrB = {0, 1, 3, 5, 11, 16, 17, 20, 25};
        ListNode headA = ListNode.makeList(arrA);
        ListNode headB = ListNode.makeList(arrB);

        int[] result = common.findCommonParts(headA, headB);

        for (int r : result)
            System.out.println(r);
    }

}
