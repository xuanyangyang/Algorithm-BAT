package MyTree;

/**
 * 前序遍历：先访问根节点，再访问左子树，最后访问右子树
 * 中序遍历：先访问左子树，再访问根节点，最后访问右子树
 * 后序遍历：先访问左子树，再访问右子树，最后访问根节点
 * 层序遍历：每一层从左到右访问每一个节点。
 */
public class Tree {
    private TreeNode root;

    public Tree() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        t3.left = t5;
        t3.right = t6;

        t5.left = t7;
        t5.right = t8;

        this.root = t1;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
