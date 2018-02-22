package ch07;

import MyTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 7.3
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence2 {
    public int[][] convert(TreeNode root) {
        // write code here
        int[][] result = new int[3][];
        for (int i = 0; i < 3; i++) {
            List<Integer> tempList = new ArrayList<>();
            if (i == 0)
                preOrderWalk(root, tempList);
            else if (i == 1)
                midOrderWalk(root, tempList);
            else
                backOrderWalk2(root, tempList);

            int dataSize = tempList.size();
            int data[] = new int[dataSize];
            for (int index = 0; index < dataSize; index++)
                data[index] = tempList.get(index);
            result[i] = data;
        }

        return result;
    }

    // 先序遍历
    public void preOrderWalk(TreeNode root, List result) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);

        }
    }

    // 中序遍历
    public void midOrderWalk(TreeNode root, List result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode node;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                node = stack.pop();
                result.add(node.val);
                cur = node.right;
            } else {
                stack.add(cur);
                cur = cur.left;
            }
        }
    }

    // 后序遍历1
    public void backOrderWalk1(TreeNode root, List result) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        TreeNode cur;
        while (!s1.isEmpty()) {
            cur = s1.pop();
            if (cur != null) {
                s2.add(cur);
                s1.add(cur.left);
                s1.add(cur.right);
            }
        }
        while (!s2.isEmpty())
            result.add(s2.pop().val);
    }

    // 后序遍历2
    public void backOrderWalk2(TreeNode root, List result) {
        Stack<TreeNode> s1 = new Stack<>();
        s1.add(root);
        TreeNode h = root;
        TreeNode c;
        while (!s1.isEmpty()) {
            c = s1.peek();
            if (c.left != null && h != c.left && h != c.right)
                s1.add(c.left);
            else if (c.right != null && h != c.right)
                s1.add(c.right);
            else {
                h = s1.pop();
                result.add(h.val);
            }
        }
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

        TreeToSequence2 treeToSequence = new TreeToSequence2();

        int[][] result = treeToSequence.convert(t1);

        for (int[] row : result) {
            for (int value : row)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}
