package ch07;

import MyTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 7.9
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        boolean isCheckLeaf = false; // 是否检查是叶子节点
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left == null) { // 有右子树，必须有左子树
                if (node.right != null)
                    return false;
            } else {
                if (isCheckLeaf)
                    return false;
                else
                    queue.add(node.left);
            }
            if (node.right == null) { // 当前节点右子树为空则以后的节点都是叶子节点
                isCheckLeaf = true;
            } else {
                queue.add(node.right);
            }
        }
        return true;
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

        t3.left = t5;
        t3.right = t6;

        CheckCompletion checkCompletion = new CheckCompletion();
        boolean isCompletion = checkCompletion.chk(t1);

        System.out.println(isCompletion);
    }
}
