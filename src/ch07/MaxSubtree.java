package ch07;

import MyTree.TreeNode;

/**
 * 7.14
 * 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */
public class MaxSubtree {
    public TreeNode getMax(TreeNode root) {
        // write code here
        return getMax(root, new int[3]);
    }

    public TreeNode getMax(TreeNode node, int[] temp) {
        if (node == null) {
            temp[0] = Integer.MAX_VALUE; // 最小值取最大值，这样所有的数都能比它小
            temp[1] = Integer.MIN_VALUE; // 最大值取最小值，这样所有的数都能比它大
            temp[2] = 0;
            return null;
        }

        TreeNode lMaxNode = getMax(node.left, temp);
        int lMin = temp[0]; // 最小值
        int lMax = temp[1]; // 最大值
        int lNum = temp[2]; // 节点数

        TreeNode rMaxNode = getMax(node.right, temp);
        int rMin = temp[0];
        int rMax = temp[1];
        int rNum = temp[2];

        temp[0] = Math.min(lMin, node.val); // 更新最小值
        temp[1] = Math.max(rMax, node.val); // 更新最大值

        if (lMaxNode == node.left && rMaxNode == node.right && lMax < node.val && rMin > node.val) {
            temp[2] = lNum + rNum + 1; // 更新节点数
            return node;
        } else {
            temp[2] = Math.max(lNum, rNum);
            return lNum > rNum ? lMaxNode : rMaxNode; // 当相等的时候取右边的，因为右边的权值大
        }
    }
}
