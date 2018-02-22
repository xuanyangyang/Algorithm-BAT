package ch07;

import MyTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.2
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class TreeToSequence {

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
                backOrderWalk(root, tempList);

            int dataSize = tempList.size();
            int data[] = new int[dataSize];
            for (int index = 0; index < dataSize; index++)
                data[index] = tempList.get(index);
            result[i] = data;
        }

        return result;
    }

    // 前序遍历
    public void preOrderWalk(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        preOrderWalk(node.left, result);
        preOrderWalk(node.right, result);
    }

    // 中序遍历
    public void midOrderWalk(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        midOrderWalk(node.left, result);
        result.add(node.val);
        midOrderWalk(node.right, result);
    }

    // 后序遍历
    public void backOrderWalk(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        backOrderWalk(node.left, result);
        backOrderWalk(node.right, result);
        result.add(node.val);
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

        TreeToSequence treeToSequence = new TreeToSequence();

        int[][] result = treeToSequence.convert(t1);

        for(int[] row:result){
            for(int value:row)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}
