package ch07;

import MyTree.TreeNode;

/**
 * 7.13
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */
public class LongestDistance {

    public int findLongest(TreeNode root) {
        int[] temp = new int[1];
        return find(root, temp);
    }

    public int find(TreeNode node, int[] temp) {
        if (node == null) {
            temp[0] = 0;
            return 0;
        }

        int lMax = find(node.left, temp);
        int maxFormLeft = temp[0];
        int rMax = find(node.right, temp);
        int maxFormRight = temp[0];

        int cMax = maxFormLeft + maxFormRight + 1;
        temp[0] = Math.max(maxFormLeft, maxFormRight) + 1;

        return Math.max(Math.max(lMax, rMax), cMax);
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

        t4.left = t6;
        t5.right = t7;

        t6.left = t8;
        t7.right = t9;

        LongestDistance longestDistance = new LongestDistance();
        int distance = longestDistance.findLongest(t1);
        System.out.println(distance);
    }

}
