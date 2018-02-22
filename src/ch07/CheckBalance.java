package ch07;

import MyTree.TreeNode;

/**
 * 7.8
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 */
public class CheckBalance {

    public boolean check(TreeNode root) {
        // write code here
        boolean[] result = new boolean[1];
        result[0] = true;
        getHeight(root, 1, result);
        return result[0];
    }

    public int getHeight(TreeNode node, int level, boolean[] res) {
        if (node == null)
            return level;
        int lh = getHeight(node.left, level + 1, res);
        if (!res[0])
            return level;
        int rh = getHeight(node.right, level + 1, res);
        if (!res[0])
            return level;
        if (Math.abs(lh - rh) > 1)
            res[0] = false;
        return Math.max(lh, rh);
    }
}
