package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author Sean
 * @date 2020/05/29
 */
public class TreeTraverse {

    /**
     * 创建二叉树
     *
     * @param inputList 输入节点
     * @return 二叉树根节点
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.size() == 0) {
            return null;
        }
        TreeNode treeNode = null;
        Integer data = inputList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.left = createBinaryTree(inputList);
            treeNode.right = createBinaryTree(inputList);
        }
        return treeNode;
    }

    /**
     * 前序遍历（递归版）
     *
     * @param root 根节点
     */
    public static void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    /**
     * 中序遍历（递归版）
     *
     * @param root 根节点
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    /**
     * 后序遍历（递归版）
     *
     * @param root 根节点
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 前序遍历（迭代版）
     *
     * @param root
     */
    public static void preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (treeNode == null) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 中序遍历（迭代版）
     *
     * @param root 根
     */
    public static void inOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (treeNode == null) {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 后序遍历（迭代版）
     *
     * @param root 根节点
     */
    public static void postOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                stack2.push(0);
                root = root.left;
            }
            while (!stack.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.println(stack.pop().val);
            }
            if (!stack.empty()) {
                stack2.pop();
                stack2.push(1);
                root = stack.peek();
                root = root.right;
            }
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        TreeNode binaryTree = createBinaryTree(inputList);
        //preorderTraversal(binaryTree);
        //inOrderTraversal(binaryTree);
        // postOrderTraversal(binaryTree);
        //preorderTraversal(binaryTree);
        // inOrderTraversal2(binaryTree);
        postOrderTraversal2(binaryTree);
    }

}
