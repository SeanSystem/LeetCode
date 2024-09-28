package hot100;

/**
 * 二叉树直径
 */
public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int LD = dfs(root.left);
        int RD = dfs(root.right);
        ans = Math.max(ans, LD + RD + 1);
        return Math.max(LD, RD) + 1;
    }

}
