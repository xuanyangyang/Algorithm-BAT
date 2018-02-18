package ch03;

import MyTree.Tree;
import MyTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 3.2
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        String AS = treeToStringWithStack(A);
        String BS = treeToStringWithStack(B);
        return AS.contains(BS);
    }

    // 层序遍历  未实现序列化，只是遍历
    public String treeToStringWithQueue(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                result.append("#!");
            else {
                result.append(node.val).append("!");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return result.toString();
    }

    // 先序遍历
    public String treeToStringWithStack(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        TreeNode node;

        while (!stack.empty()) {
            node = stack.pop();
            if (node == null)
                result.append("#!");
            else {
                result.append(node.val).append("!");
                stack.add(node.right);
                stack.add(node.left);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        IdenticalTree identicalTree = new IdenticalTree();
        String result = identicalTree.treeToStringWithQueue(tree.getRoot());
        System.out.println(result);
        TreeNode treeNode = new TreeNode(1);
        String result2 = identicalTree.treeToStringWithQueue(treeNode);
        System.out.println(result2);
        String result3 = identicalTree.serialByPre(tree.getRoot());
        String result4 = identicalTree.serialByPre(treeNode);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result3.contains(result4));
        result = identicalTree.treeToStringWithStack(tree.getRoot());
        System.out.println(result);
    }

    // 递归先序遍历
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
}
