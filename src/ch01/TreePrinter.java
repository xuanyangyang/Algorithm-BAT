package ch01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        List<List<Integer>> datas = new ArrayList<>();
        List<Integer> rowData = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode last = root;
        TreeNode nLast = null;
        TreeNode temp;
        queue.add(root);

        while (queue.size() != 0) {
            temp = queue.poll();
            TreeNode left = temp.left;
            if (left != null) {
                queue.add(left);
                nLast = left;
            }
            TreeNode right = temp.right;
            if (right != null) {
                queue.add(right);
                nLast = right;
            }
            rowData.add(temp.val);
            if (last == temp) {
                datas.add(rowData);
                rowData = new ArrayList<>();
                last = nLast;
            }
        }

        int row = datas.size();
        int[][] result = new int[row][];
        for (int i = 0; i < row; i++) {
            List<Integer> colDatas = datas.get(i);
            int col = colDatas.size();
            int[] colResult = new int[col];
            for (int j = 0; j < col; j++) {
                colResult[j] = colDatas.get(j);
            }
            result[i] = colResult;
        }
        return result;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        TreePrinter treePrinter = new TreePrinter();
        int[][] result = treePrinter.printTree(tree.getRoot());
        for (int i = 0; i < result.length; i++) {
            int[] colResult = result[i];
            for (int j = 0; j < colResult.length; j++) {
                System.out.print(colResult[j] + " ");
            }
            System.out.println();
        }
    }
}