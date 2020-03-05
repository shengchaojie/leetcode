package com.scj.leetcode.bst;

/**
 * @author shengchaojie
 * @date 2020-03-03
 **/
public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null) return false;
        if (tree2 == null) return false;

        if (tree1.val != tree2.val) return false;

        return isSymmetric(tree1.left,tree2.right) &&isSymmetric(tree1.right,tree2.left);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        root.left = left;
        root.right = right;

        left.right=c;
        right.right=c;

        _101_对称二叉树 _this = new _101_对称二叉树();
        System.out.println(_this.isSymmetric(root));
    }

}
