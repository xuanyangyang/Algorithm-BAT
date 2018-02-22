package ch07;

import MyTree.TreeNode;

import java.util.Stack;

/**
 * 7.12
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        // write code here
        int[] result = new int[2];

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode preNode = null; // 上一个打印节点
        TreeNode curNode; // 当前打印节点
        int count = 0;

        while (cur != null || !stack.empty()) {
            if (cur == null) {
                curNode = stack.pop();
                if (preNode != null) {
                    if (preNode.val > curNode.val) {
                        count++;
                        if (count == 1) {
                            result[0] = curNode.val;
                            result[1] = preNode.val;
                        } else {
                            result[0] = curNode.val;
                        }
                    }
                }
                preNode = curNode;
                cur = curNode.right;
            } else {
                stack.add(cur);
                cur = cur.left;
            }
        }

        return result;
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

//        t4.left = t8;
//        t4.right = t9;

        FindErrorNode findErrorNode = new FindErrorNode();

        int[] result = findErrorNode.findError(t1);

        for (int value : result)
            System.out.print(value + " ");
    }
}


