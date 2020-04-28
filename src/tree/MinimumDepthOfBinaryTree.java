package tree;

import java.util.LinkedList;

/**
 * 求二叉树的最小深度
 *
 * @author by Sean
 * @date 2020/4/27 21:33
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 深度优先遍历
     * 简单、效率低
     */
    public static int run1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = run1(node.left);
        int r = run1(node.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }

    /**
     * 广度优先遍历
     * 效率高
     */
    public static int run2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        int start = 0;
        int end = 1;
        int level = 1;
        treeNodes.addFirst(node);
        while (!treeNodes.isEmpty()) {
            start++;
            TreeNode temp = treeNodes.removeLast();
            if (temp.left == null && temp.right == null) {
                return level;
            }
            if (temp.left != null) {
                treeNodes.addFirst(temp.left);
            }
            if (temp.right != null) {
                treeNodes.addFirst(temp.right);
            }
            if (start == end) {
                start = 0;
                end = treeNodes.size();
                level++;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.setLeft(new TreeNode(2));
        node.setRight(new TreeNode(3));
        System.out.println(run1(node));
        System.out.println(run2(node));
    }
}
