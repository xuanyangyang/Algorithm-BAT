package ch06;

import MyTree.TreeNode;


/**
 * 6.7
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 */
public class CountNodes {
    public int count(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    public int bs(TreeNode node, int level, int high) {
        if (level == high)
            return 1;
        // 如果右子树的高度等于左子树高度则表示左子树是一棵满二叉树，可用公示计算左子树大小（带头节点），然后遍历右子树重复本操作
        if (mostLeftLevel(node.right, level + 1) == high)
            return (int) (Math.pow(2, high - level) + bs(node.right, level + 1, high));
        else
            return (int) (Math.pow(2, high - level - 1) + bs(node.left, level + 1, high));
    }

    // 获取高度
    public int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        t4.left = t8;
        t4.right = t9;

        CountNodes countNodes = new CountNodes();

        int result = countNodes.count(t1);

        System.out.println("节点数为：" + result);
    }
}
