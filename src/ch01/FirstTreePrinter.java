package ch01;

import MyTree.Tree;
import MyTree.TreeNode;

import java.util.Stack;

/**
 * 先序遍历
 */

public class FirstTreePrinter {
    // 非递归
    public void printTreeWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node;

        while (!stack.empty()) {
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
    }

    // 递归
    public void printTreeWithRecursive(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        printTreeWithRecursive(node.left);
        printTreeWithRecursive(node.right);
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        FirstTreePrinter firstTreePrinter = new FirstTreePrinter();
        firstTreePrinter.printTreeWithStack(tree.getRoot());
        System.out.println();
        firstTreePrinter.printTreeWithRecursive(tree.getRoot());
    }
}
