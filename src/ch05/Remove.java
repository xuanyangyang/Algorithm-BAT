package ch05;

/**
 * 5.3
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 */
public class Remove {
    // 常规删除
    public ListNode removeNode(ListNode pNode, int delVal) {
        // write code here
        if (pNode != null) {
            ListNode pre = pNode;
            ListNode cur = pre.next;

            if (pNode.val == delVal)
                return pNode.next;
            else {
                while (cur != null) {
                    if (cur.val == delVal) {
                        pre.next = cur.next;
                    }
                    pre = cur;
                    cur = cur.next;
                }
            }
        }

        return pNode;
    }

    // 不需要前节点的删除方式，不可删除最后一个节点
    public ListNode removeNode2(ListNode pNode, int delVal) throws Exception {
        if (pNode != null) {
            ListNode node = pNode;
            while (node != null) {
                if (node.val == delVal) {
                    if (node.next == null) {
                        throw new Exception("不可用本方法删除最后一个节点");
                    }
                    node.val = node.next.val;
                    node.next = node.next.next;
                    break;
                }
                node = node.next;
            }
        }

        return pNode;
    }

    // 视频中的删除方法，不可删除最后一个节点
    public boolean removeNode(ListNode pNode) {
        if (pNode == null) {
            return false;
        }
        ListNode next = pNode.next;
        if (next == null) {
            return false;
        }
        pNode.val = next.val;
        pNode.next = next.next;
        return true;
    }
}
