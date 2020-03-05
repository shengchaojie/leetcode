package com.scj.leetcode.bst;

import java.util.Arrays;

/**
 * @author shengchaojie
 * @date 2020-03-04
 **/
public class _106_从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length ==0 ) return null;

        int rootIndex = 0;
        while(inorder[rootIndex]!=postorder[postorder.length-1]){rootIndex++;}

        TreeNode root = new TreeNode(postorder[postorder.length-1]);

        root.left = buildTree(Arrays.copyOfRange(inorder,0,rootIndex),Arrays.copyOfRange(postorder,0,rootIndex));
        root.right = buildTree(Arrays.copyOfRange(inorder,rootIndex+1,inorder.length),Arrays.copyOfRange(postorder,rootIndex,postorder.length-1));
        return root;
    }

}
