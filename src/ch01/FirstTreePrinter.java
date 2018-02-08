package ch01;

import java.util.Stack;

/**
 * 先序遍历
 */

public class FirstTreePrinter {
    public void printTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (null != node || !stack.empty()) {

            while (null != node){
                System.out.print(node.val + " ");
                stack.add(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        FirstTreePrinter firstTreePrinter = new FirstTreePrinter();
        firstTreePrinter.printTree(tree.getRoot());
    }
}
